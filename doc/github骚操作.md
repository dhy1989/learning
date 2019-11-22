# github必须要会的操作
## 常见的关键字
watch:相当于订阅,当别人提交什么请求的时候都会通知你,一般都是not watching
star:相当于点赞,你的个人选项下边有一个your stars可以查看你所有点赞过的项目  
Fork:相当于你自己有了一份这个项目的拷贝,如果后期项目发生改变,你必须通过其他方式进行同步  
## 高效搜索项目
1.in查询
    SpringBoot in:name　　查找项目名称中包含SpringBoot  
    SpringBoot in:name,description　　查找项目名称,描述中包含SpringBoot  
    SpringBoot in: name,description,readme　　查找项目名称、描述、readme中包含SpringBoot  
2.:>或:<  
    SpringBoot stars:>5000　　查找点赞数超过5000的项目  
    SpringBoot forks:>5000   查找forks数大于5000的项目  
3.数字1..数字2  区间范围数字查询  
SpringCloud stars:200..9999 forks:100..2000　　查找stars在200到9999，forks在100到2000的项目  
4.awesome   
awesome一般是用来收集学习、工具、书籍类相关的项目   
awesome redis　搜索优秀的redis相关项目，包括框架、教程等  
5.高亮显示某一行代码  
   * 高亮显示1行：地址后紧跟#L行数
   * 高亮显示多行：地址后紧跟#L行数-L行数  
   示例: https://github.com/dhy1989/mybatis-demo/blob/master/src/main/java/com/dhy/demo/controller/UserController.java#L11-L12  

6.项目内搜索  
  使用按键 t  

7.查看你在城市的大牛,可以follow,会推荐他们的动态  
location:zhengzhou language:Java    
