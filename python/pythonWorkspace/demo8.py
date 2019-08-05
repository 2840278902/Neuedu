# 3.中文分词  jieba

# 安装jieba分词库
#  指定国内镜像安装
#1.在用户目录下新建pip文件夹
# 2.新建pip.ini文件
# 添加
"""
[global]
index-url = http://mirrors.aliyun.com/pypi/simple/
[install]
trusted-host=mirrors.aliyun.com
"""
# pip install jieba

# 导入jieba分词
import jieba
# 三种分词模式
seg = "我来到北京清华大学"
# 精确模式  精确分词
seg_list = jieba.lcut(seg)
print(seg_list)
# 全模式  找出所有可能的分词结果    冗余性大
seg_list1 = jieba.lcut(seg,cut_all=True)
print(seg_list1)
#  搜索引擎模式
seg_list2 = jieba.lcut_for_search(seg)
print(seg_list2)

#
text = '小明硕士毕业于中国科学院计算所，后在日本京都大学深造'
seg_list4 = jieba.lcut(text,cut_all=True)
print(seg_list4)
#  搜索引擎模式  先执行精确模式，在对其中的长词进行处理
seg_list5 = jieba.lcut_for_search(text)
print(seg_list5)

# nlp


# 4. 词云的展示