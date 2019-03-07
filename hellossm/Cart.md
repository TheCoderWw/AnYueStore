前端在商品详情页点击加入购物车:
    post访问接口
        http://47.94.108.73:8080/ayms/cart/addGoods
    提交数据字段:
        commId      //商品id(int)
        goodsSize   //商品size(String)
        goodsColor  //颜色(String)
        goodsSum    //商品数量(int)
        如:
        {
          	      "commId":3,
                  "goodsSize":"L",
                  "goodsColor":"红色",
                  "goodsSum":10
        }
        返回status:200
        
        
展示购物车信息:
    get访问接口
        http://47.94.108.73:8080/ayms/cart/getAllGoods(带token)
        返回信息见截图
        
        
删除购物车商品:
    post访问接口
        http://47.94.108.73:8080/ayms/cart/deleteGoods 
         格式如下:
               {
               	"cartGoods": [
                           {
                               "cartId": 4
                           },
                           {
                           	"cartId":5
                           }
                         ,{
                         	"cartId":3
                         }
                           ]
               }
               
         返回status:200
        