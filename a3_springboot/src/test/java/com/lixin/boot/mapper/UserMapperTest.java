package com.lixin.boot.mapper;


import com.lixin.boot.SpringBootDemoOrmMybatisApplicationTests;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * UserMapper 测试类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 11:25
 */
@Slf4j
public class UserMapperTest extends SpringBootDemoOrmMybatisApplicationTests {
   /* @Autowired
    private UserMapper userMapper;

    *//**
     * 测试查询所有
     *//*
    @Test
    public void selectAllUser() {
        List<User> userList = userMapper.selectAllUser();
        log.debug("【userList】= {}", userList);
    }

    *//**
     * 测试根据主键查询单个
     *//*
    @Test
    public void selectUserById() {
        User user = userMapper.selectUserById(1L);
        Assert.assertNotNull(user);
        log.debug("【user】= {}", user);
    }

    *//**
     * 测试保存
     *//*
    @Test
    public void saveUser() {
        String salt = IdUtil.fastSimpleUUID();
        User user = User.builder().name("testSave3").password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        int i = userMapper.saveUser(user);
        Assert.assertEquals(1, i);
    }

    *//**
     * 测试根据主键删除
     *//*
    @Test
    public void deleteById() {
        int i = userMapper.deleteById(1L);
        Assert.assertEquals(1, i);
    }*/
}
