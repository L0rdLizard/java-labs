package dev.maxim.lab15;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class PostList {
    private ArrayList<Post> posts = new ArrayList<>();

    public void add(Post ad) {
        posts.add(ad);
    }
}