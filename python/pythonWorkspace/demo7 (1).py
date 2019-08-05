# 2.本地文件读取
# python中使用open内置函数进行文件读取
# f = open(file='./novel/threekingdom.txt', mode='r', encoding='utf-8')
# data = f.read()
# f.close()
# # data = open(file='./novel/threekingdom.txt', mode='r', encoding='utf-8').read()
# print(data)

# with as 上下文管理器  不用手动关闭流
# with open('./novel/threekingdom.txt', 'r', encoding='utf-8') as f:
#     data = f.read()
#     print(data)


# 写入
# txt = 'i like python'
# with open('python.txt','w', encoding='utf-8') as f:
#     f.write(txt)

text = """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>重庆师范欢迎你</h1>
</body>
</html>"""
print(text)
with open('chongqingshifan.html','w', encoding='utf-8') as f:
    f.write(text)

