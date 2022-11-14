package entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user_favorites", schema = "seminarUserService")
public class UserFavorites {
   // private int id;
    private String favorite;

    private User user;
//    @Id
//    @GeneratedValue(
//            strategy= GenerationType.AUTO,
//            generator = "favorites_id"
//    )
//    @SequenceGenerator(
//            name = "favorites_id",
//            sequenceName = "seminarUserService.seq_stellenausschreibung_id",
//            allocationSize=1
//    )

//    @Column(name = "favorite_id")
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
    @Id
    @ManyToOne()
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user =user;
    }

    @Column(name = "favorite")
    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

}
