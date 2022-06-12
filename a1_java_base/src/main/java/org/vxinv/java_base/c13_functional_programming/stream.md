### faltMap 和 map 的区别

+ map 新生成的stream 只包含转换生成的元素 两者一一对应

+ flatMap 转换得到的是Stream对象 ，会把得到的子 stream 压缩到 父stream 中
 

+ map
```text
    public static void main(String[] args) throws Exception {
        // 将集合中的所有的小写字母转为大写字母
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("python");
        List<String> result = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result);
    }

```

```text
[HELLO, WORLD, JAVA, PYTHON]

```

+ flatmap

```text
    public static void main(String[] args) throws Exception {
        // 将集合中的字符串中单词提取出来，不考虑特殊字符
        List<String> words = Arrays.asList("hello c++", "hello java", "hello python");
        List<String> result = words.stream()
                // 将单词按照空格切合，返回Stream<String[]>类型的数据
                .map(word -> word.split(" "))
                // 将Stream<String[]>转换为Stream<String>
                .flatMap(Arrays::stream)
                // 去重
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }

```
```text
[hello, c++, java, python]
```

```text
public class Main {

    public static void main(String[] args) throws Exception {
        // 初始化测试数据
        List<String> hobby1 = Arrays.asList("java", "c", "音乐");
        List<String> hobby2 = Arrays.asList("c++", "c", "游戏");
        User user1 = new User(1, "张三", hobby1);
        User user2 = new User(2, "李四", hobby2);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        // 将集合中每个用户的爱好进行计算，取并集
        List<String> result = users.stream()
                .map(user -> user.hobby)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static class User {
        int id;
        String name;
        List<String> hobby;

        public User(int id, String name, List<String> hobby) {
            this.id = id;
            this.name = name;
            this.hobby = hobby;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}


```

