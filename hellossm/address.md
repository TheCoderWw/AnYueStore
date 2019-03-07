获取当前登录用户所有收获地址
	前端直接访问接口 http://47.94.108.73:8080/ayms/address/getAllAddress(带着token)
    返回:(假设当前登录用户为id=51的用户)
    {
        "addressList": [
            {
                "id": 3,
                "userId": 51,
                "addrName": "你好啊啊",
                "cnee": "ewqewqe",
                "addrPhone": "446213"
            }
        ],
        "status": 200
    }
    若该用户无收货地址,则返回:
    {
        "addressList": [],
        "status": 200
    }
    
用户增加收货地址:
    接口:http://47.94.108.73:8080/ayms/address/addAddress(带着token)
    测试:
    前端传入:{
             "addrName": "王伟31",
             "cnee": "www",
             "addrPhone": "45678123"
         }
    后端返回:{
             "status": 200
         }
         
用户修改收货地址:
    接口:http://47.94.108.73:8080/ayms/address/updateAddress(带着token)
    测试:
    前端传入:{
                     "id": 4,
                     "addrName": "西安市xxxx",
                     "cnee": "www",
                     "addrPhone": "45678123"
                 }
    后端返回:{
             "status": 200
         }

用户删除收货地址:
    post:接口:http://47.94.108.73:8080/ayms/address/deleteAddress(带着token)
    测试:
    前端传入:{
                     "id": 4    
                 }
    后端返回:{
             "status": 200
         }
    
    