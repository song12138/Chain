package builder;

/**
 * Created by paul on 2017/11/9.
 */
public class User {
    private String username;

    private String age;

    private String sex;

    private String height;

    private String weight;


    private User(UserBuilder userBuilder) {
        this.username = userBuilder.username;
        this.age = userBuilder.age;
        this.sex = userBuilder.sex;
        this.height = userBuilder.height;
        this.weight = userBuilder.weight;
    }

    public String getUsername() {
        return username;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public static class UserBuilder {
        private String username;

        private String age;

        private String sex;

        private String height;

        private String weight;

        public UserBuilder() {

        }

        public UserBuilder(String username, String age) {
            this.username = username;
            this.age = age;
        }


       public UserBuilder username(String username){
           this.username = username;
           return this;
       }
       public UserBuilder age(String age){
           this.age = age;
           return this;
       }
       public UserBuilder sex(String sex){
           this.sex = sex;
           return this;
       }
       public UserBuilder height(String height){
           this.height = height;
           return this;
       }
       public UserBuilder weight(String weight){
           this.weight = weight;
           return this;
       }


        public User build() {
            return new User(this);
        }

    }
}