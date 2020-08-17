# 数据库学习资料管理系统 #

### 入门使用

1. 打开IDEA，右上角File，Open，直接打开项目文件即可
2. 导入你的SDK版本，IDEA会有提示，你点一下版本就行了（如果你之前配置过）
3. 运行![image-20200817234003500](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200817234003500.png)这个主函数，![image-20200817234050826](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200817234050826.png)看到这行文字说明运行成功。
4. 导入数据库，在Navicat中创建名字为learningsystem的数据库，运行document中的.sql文件

### 模块设计

+ 登录注册模块、

  >实现用户的登录，管理员的登录

  [前台登录地址](http://localhost:8080/student/login) 

  [后台登录地址](http://localhost:8080/admin/login)

  [接口调试地址](http://localhost:8080/swagger-ui.html)

  以上地址启动springBoot之后按住Ctrl点击就能直接访问了

  > > 账号密码导入数据库之后可以直接查看

+ 学习资料设置模块

  >管理员在后台可以上传或者修改资料，并呈现于用户

  > 设置学习资源得先添加一个标题，![image-20200817235717771](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200817235717771.png)点这个，然后再点击![image-20200817235757041](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200817235757041.png)就可以按照同样的逻辑为这个标题添加内容了，

  编辑好你的内容之后你可以再次前往[前台登录地址](http://localhost:8080/student/login)， 看看你刚才编辑的内容是否在页面上显示

+ 用户管理模块

  >对用户进行CRUD操作
  
  > > 学生管理与管理员管理按钮，具体功能也请自己摸索，普通后台管理页面而已，你们肯定有接触过的

---

### 温馨提醒  

看到![image-20200817235458017](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200817235458017.png)

这种页面请不用方，404表示资源未找到而已。

未尽事宜，请联系本人。