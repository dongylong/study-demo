//package com.java8.oreilly.chp7;
//
//import Album;
//import Track;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.function.ToLongFunction;
//import java.util.stream.Collectors;
//
//public class LoggerDemo {
//    public void logg() {
//        Logger logger = Logger.getLogger("log.text");
//        logger.debug("Look at this: " + expensiveOperation());
//        logger.debug(() -> "Look at this: " + expensiveOperation());
//    }
//
//    ThreadLocal<Album> thisAlbum = new ThreadLocal<Album>() {
//        @Override
//        protected Album initialValue() {
//            return database.lookupCurrentAlbum();
//        }
//    };
//
//    //信噪比降低
//    //jvm少加载一个类
//    ThreadLocal<Album> thisAlbum1 = ThreadLocal.withInitial(
//            () -> database.lookupCurrentAlbum());
//
//    /**
//     * 7.5
//     *
//     * @return
//     */
//    public long countRunningTime() {
//        long count = 0;
//        for (Album album : albums) {
//            for (Track track : album.getTracks()) {
//                count += track.getLength();
//            }
//        }
//        return count;
//    }
//
//    List<Album> albums;
//
//    public long countMusicians() {
//        long count = 0;
//        for (Album album : albums) {
//            count += album.getMusicianList().size();
//        }
//        return count;
//    }
//
//    public long countTracks() {
//        long count = 0;
//        for (Album album : albums) {
//            count += album.getTrackList().size();
//        }
//        return count;
//    }
//
//    /**
//     * 7.6
//     */
//    public long countRunningTime() {
//        return albums.stream()
//                .mapToLong(album -> album.getTracks()
//                        .mapToLong(track -> track.getLength())
//                        .sum())
//                .sum();
//    }
//
//    public long countMusicians() {
//        return albums.stream()
//                .mapToLong(album -> album.getMusicians().count())
//                .sum();
//    }
//
//    public long countTracks() {
//        return albums.stream()
//                .mapToLong(album -> album.getTracks().count())
//                .sum();
//    }
//    /**
//     * 7.7 领域方法重构Order类
//     */
//    public long countFeature(ToLongFunction<Album> function){
//        return albums.stream().mapToLong(function).sum();
//    }
//    public long countTracks(){
//        return countFeature((album->album.getTracks().count()));
//    }
//    public long countRunningTime(){
//        return countFeature(album->album.getTracks()
//        .mapToLong(track->track.getLength()).sum());
//    }
//    public long countMusicians(){
//        return countFeature(album->album.getMusicians().count());
//    }
//
//    public static List<String> allToUpperCase(List<String>  words){
//        return words.stream().map(string->string.toUpperCase())
//                .collect(Collectors.<String>toList());
//    }
//    public static List<String> elementFirstToUpperCaseLambdas(List<String> words){
//        return words.stream().map(value->{
//            char firstChar = Character.toUpperCase(value.charAt(0));
//            return firstChar+value.substring(1);
//        }).collect(Collectors.toList());
//    }
//
//
//}
