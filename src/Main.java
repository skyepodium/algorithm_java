class Main {
    public static void main(String[] args) {
        Post post = Post.builder()
                        .author("skyepodium")
                        .title("design-pattern")
                        .content("builder")
                        .build();

        System.out.println(post);
    }
}

class Post {
    private String author;
    private String title;
    private String content;

    private Post(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.content = builder.content;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String author;
        private String title;
        private String content;

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}