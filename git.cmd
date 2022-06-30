git pull origin master
git add .

# 普通提交代码
cd C:\Users\Administrator\code\JavaCode\awesome_java\
git add .
git commit -m 'test'
git push origin master



# 删除已经提交的文件
git rm -r --cache ./path...
git push origin master

# 强制更新
git fetch --all  //将远程主机的最新内容拉到本地
git reset --hard origin/master  //强制更新覆盖本地

# 强制推送
git push -f origin master

#  更换git托管
 git remote rm origin
 git remote add origin git@github.com:vxinv/notes.git
