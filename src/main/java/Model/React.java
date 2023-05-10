package Model;

public class React {

    private User userOwner;
    private Post post;

    public React(User userOwner, Post post)
    {
        this.userOwner = userOwner;
        this.post = post;
    }


    public User getUserOwner()
    {
        return userOwner;
    }

    public Post getPost()
    {
        return post;
    }




}
