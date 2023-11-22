package dev.maxim.lab15;

import lombok.Synchronized;
import lombok.ToString;

import java.util.ArrayList;

@ToString
public class PostListStore {
    private static volatile PostListStore instance;

    private PostList board = new PostList();

//    public AdBoardStore(String databasePath) {
//
//    }

    public static PostListStore getInstance() {
        if (instance == null) {
            synchronized (PostList.class) {
                if (instance == null) {
                    instance = new PostListStore();
                }
            }
        }
        return instance;
    }


    @Synchronized
    public ArrayList<Post> getAds() {
        return board.getAds();
    }

    @Synchronized
    public void add(Post ad) {
        board.add(ad);
    }
}