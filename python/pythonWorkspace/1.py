import requests
import json
proxy_info = {'host': 'web-proxy.oa.com', 'port': 8080}
headers={'User-Agent':'Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36'}
link="https://www.acfun.cn/rest/pc-direct/comment/listByFloor?sourceId=10637821&sourceType=3&page=1&pivotCommentId=0&newPivotCommentId=0&_ts=6"
r=requests.get(link,headers=headers,proxies=proxy_info)
# 获取 json 的 string
json_string = r.content.decode()
json_string = json.loads(json_string)
json_string = json_string['commentsMap']
n = 1
for dict_key in json_string.keys():
    print(n)
    n += 1
    a = dict_key
    print(json_string[a])
