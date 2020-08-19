### 这是一个我用来大数据分析微博评论用户的前后端及数据收集及部分数据处理的代码仓库。

 #### wb_ca

- 是用来收集或者爬取微博评论用户的信息，包括用户名，生日，手机，评论内容等信息。

- 所用技术 **httpClient、JSoup、ipPorxy**等

  

#### fenci

- 用于将收集到的评论内容进行自然语言处理，分词并进行词频统计
- 所用技术 [ansj_seg](https://github.com/NLPchina/ansj_seg)

#### weibo

- 将用hive等工具处理过并放入mysql的数据生成后端数据接口

- 所用框架及技术 **springboot、mybatis—plus、druid**

  

#### weibo_vue

- 数据可视化（前端代码）
- 所用框架及技术 **vue.js、highchart.js**