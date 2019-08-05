# 图片的下载
import requests
url = 'http://g.hiphotos.baidu.com/image/pic/item/5366d0160924ab18014cefd83bfae6cd7a890b82.jpg'
response = requests.get(url)
# 获取bytes类型的响应
data = response.content
with open('风景.png','wb') as f:
    f.write(data)