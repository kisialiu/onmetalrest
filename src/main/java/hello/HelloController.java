package hello;

import hello.exception.ResourceNotFoundException;
import hello.model.*;
import hello.repo.AlbumRepository;
import hello.repo.BandRepository;
import hello.repo.PersonRepository;
import hello.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @Autowired
    private BandRepository bandRepository;

    @Autowired
    private AlbumRepository albumsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private SearchBandCache<String, List<Search>> cache = new SearchBandCache<>(60000);

    @RequestMapping(method = RequestMethod.GET, path = "band")
    public Band getBand(
            @RequestParam(value = "bandName", required = false) String bandName,
            @RequestParam(value = "id", required = false) String id
    ) {
        if (bandName == null && id == null) {
            throw new IllegalStateException("Please search band by id or name, not both");
        } else if (bandName != null && !bandName.isEmpty()) {
            return bandRepository.findByBandNameIgnoreCase(bandName);
        } else if (id != null && !id.isEmpty()) {
            return bandRepository.findOne(id);
        } else {
            throw new IllegalStateException("Please search band by id or name");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "bands")
    public List<Band> getBands(
            @RequestParam("bandName") String bandName
    ) {
        return bandRepository.findByBandNameRegex(bandName);
    }

    @RequestMapping(method = RequestMethod.GET, path = "search/bands")
    public Page<Search> getSearchBands(
            @RequestParam(value = "bandName", required = false) String bandName,
            @RequestParam(value = "genre", required = false) String genre,
            Pageable pageable
    ) {
        long count;
        List<Search> searchResults;
        if (bandName != null && !bandName.isEmpty()) {
            Query queryBand = new Query();
            queryBand.addCriteria(Criteria.where("bandName").regex(bandName, "i")).with(pageable);
            searchResults = getSearchResults(mongoTemplate.find(queryBand, Band.class));
            count = mongoTemplate.count(queryBand, Band.class);
        } else if (genre != null && !genre.isEmpty()) {
            Query queryGenre = new Query();
            queryGenre.addCriteria(Criteria.where("details.genre").regex(genre, "i")).with(pageable);
            searchResults = getSearchResults(mongoTemplate.find(queryGenre, Band.class));
            count = mongoTemplate.count(queryGenre, Band.class);
        } else if ((bandName == null && genre != null) || (genre == null && bandName != null)) {
            Query queryGenre = new Query();
            queryGenre.with(pageable);
            searchResults = getSearchResults(mongoTemplate.find(queryGenre, Band.class));
            count = mongoTemplate.count(queryGenre, Band.class);
        } else {
            throw new IllegalStateException("Please search bands by band name or genre");
        }
        return new PageImpl<>(searchResults, pageable, count);
    }

    private List<Search> getSearchResults(List<Band> bands) {
        return bands
                .stream()
                .map(it -> new Search(it.getBandName(), it.getId(), it.getDetails().getGenre(), it.getDetails().getCountry()))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "disc")
    public FullAlbum getDisc(
            @RequestParam("id") String id
    ) {
        return albumsRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "discs")
    public Page<Album> getDiscs(
            @RequestParam("title") String title,
            Pageable pageable
    ) {
        Query queryBand = new Query();
        if (title == null || title.isEmpty()) {
            queryBand.with(pageable);
        } else {
            queryBand.addCriteria(Criteria.where("title").regex(title, "i")).with(pageable);
        }
        List<FullAlbum> albums = mongoTemplate.find(queryBand, FullAlbum.class);
        long count = mongoTemplate.count(queryBand, FullAlbum.class);

        return new PageImpl<>(albums
                .stream()
                .map(album ->
                        new Album(album.getId(),
                                album.getTitle(),
                                album.getType(),
                                album.getReleaseDate()))
                .collect(Collectors.toList()), pageable, count);
    }

    @RequestMapping(method = RequestMethod.GET, path = "discs/latest")
    public List<Album> getLatestDiscs(
            @RequestParam("count") int count
    ) {
        Pageable pageable = new PageRequest(0, count, new Sort(Sort.Direction.DESC, "release date"));
        Query query = new Query();
        query.addCriteria(Criteria.where("release date").lte(new Date())).with(pageable);

        List<FullAlbum> albums = mongoTemplate.find(query, FullAlbum.class);
        return albums.stream().map(album ->
                new Album(album.getId(),
                        album.getTitle(),
                        album.getType(),
                        album.getReleaseDate()))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "discs/latest/paged")
    public Page<Album> getLatestDiscsPaged(
            Pageable pageable
    ) {
        Query query = new Query();
        query.addCriteria(Criteria.where("release date").lte(new Date())).with(pageable).with(new Sort(Sort.Direction.DESC, "release date"));
        List<FullAlbum> albums = mongoTemplate.find(query, FullAlbum.class);
        long count = mongoTemplate.count(query, FullAlbum.class);

        return new PageImpl<>(albums
                .stream()
                .map(album ->
                        new Album(album.getId(),
                                album.getTitle(),
                                album.getType(),
                                album.getReleaseDate()))
                .collect(Collectors.toList()), pageable, count);
    }

    @RequestMapping(method = RequestMethod.POST, path = "users")
    public User getUser(@RequestBody User user) {
        User userDb = userRepository.findByEmailAndType(user.getEmail(), user.getType());
        if (userDb != null) {
            return userDb;
        } else {
            userRepository.save(user);
            return user;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "users")
    public void updateUser(@RequestBody User user) {
        User userDb = userRepository.findByEmailAndType(user.getEmail(), user.getType());
        if (userDb == null) {
            throw new ResourceNotFoundException();
        }
        userDb.setPhotoUrl(user.getPhotoUrl());
        userDb.setLikedAlbums(user.getLikedAlbums());
        userDb.setLikedBands(user.getLikedBands());
        userRepository.save(userDb);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "disc")
    public void likeDisc(@RequestParam("id") String id,
                         @RequestParam("like") Boolean like) {
        FullAlbum album = albumsRepository.findOne(id);
        if (like) {
            album.addLike();
        } else {
            album.removeLike();
        }
        albumsRepository.save(album);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "band")
    public void likeBand(@RequestParam("id") String id,
                         @RequestParam("like") Boolean like) {
        Band band = bandRepository.findOne(id);
        if (like) {
            band.addLike();
        } else {
            band.removeLike();
        }
        bandRepository.save(band);
    }

    @RequestMapping(method = RequestMethod.GET, path = "user")
    public UserInfo getUserInfo(@RequestParam("email") String email,
                                @RequestParam("type") String type) {
        User userDb = userRepository.findByEmailAndType(email, type);
        List<FullAlbum> albums = userDb
                .getLikedAlbums()
                .stream()
                .map(albumId -> albumsRepository.findOne(albumId))
                .collect(Collectors.toList());

        List<Band> bands = userDb
                .getLikedBands()
                .stream()
                .map(bandId -> bandRepository.findOne(bandId))
                .collect(Collectors.toList());

        return new UserInfo(albums, bands);
    }

    @RequestMapping(method = RequestMethod.GET, path = "band/lineup/current")
    public List<Person> getBandCurrentPersons(@RequestParam("bandId") String bandId) {
        return bandRepository
                .findOne(bandId)
                .getCurrentLineup()
                .stream()
                .filter(Member::getCurrent)
                .map(Member::getId)
                .map(id -> personRepository.findOne(id))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "band/todayReleases")
    public List<FullAlbum> getTodayReleases() {
        LocalDate today = LocalDate.now(ZoneId.of("UTC"));
        String str1 = today.getYear() + "-" + today.getMonthValue() + "-" + today.getDayOfMonth() + " 00:00:00";
        String str2 = today.getYear() + "-" + today.getMonthValue() + "-" + today.getDayOfMonth() + " 23:59:59";

        Query query = new Query();
        query.addCriteria(Criteria.where("release date")
                .gte(DateUtils.getDate(str1, DateUtils.DB_FORMAT_DATETIME))
                .lte(DateUtils.getDate(str2, DateUtils.DB_FORMAT_DATETIME)));
        return mongoTemplate.find(query, FullAlbum.class);
    }

}

