# CRM客户管理系统
```json
使用 MacDown 软件打开
```
## 系统提供的服务接口
## 表结构
```
id             int          主键
contact_id     bigint       联系人ID
visit_id       bigint       拜访对象ID
data_source    varchar(100) 数据来源
happen_time    datetime     发生日期
personnel      varchar(100) 人员
event          varchar(100) 事件
event_type     varchar(100) 事件类型
event_type_sub varchar(100) 事件类型子类
employee_id    varchar(100) 雇员ID
unit_id        varchar(100) 所属事业部
shop_id        varchar(100) 所属营业店
creator        varchar(100) 创建人
sale_phone     varchar(100) 业务员号码
receipt_number varchar(100) 单据编号
cdate          datetime     创建日期
```
### 接口简介
##### 请求方法 /crm/findInteractionRecordList
- **方法介绍**：查询交互记录接口
- **调用方式**： `POST`
- **请求参数**：
- 
| 参数英文名 | 参数名称 | 参数类型 | 必填 | 备注 |
|----------|---------|--------|---------|-----|
| `visitId` | 拜访对象ID| `Long` | 是 | |
| `creator` | 创建人| `String` | 是 | |
| `permission` | 权限 | `Integer` | 是 | 0: 自己本人;  3: 全公司 |
| `contactId` | 联系人ID | `Long` | 否 |默认 0 |
| `eventType` | 事件类型 | `String` | 否 | 01.常规，02.警告 |

##### 方法解释
```
当 contactId 为 0 时，根据 visitId 查询，
当 contactId 大于 0 时，则根据 visitId + contactId 查询 
如果 permission = 0 时，默认查询创建人为传入 creator 账号(包含创建人为空)的数据
如果 permission = 3，则不过滤创建人的条件, 查询全部数据。
```

##### 请求样例
```
http://172.24.121.142:8080/crm/findInteractionRecordList
{
	"visitId":202002201530445,
	"creator": "creator1",
	"permission":3,
	"contactId":202002201530445,
	"eventType":1
}
```

##### 返回结果
- **返回参数**：
- 
| 参数英文名 | 参数名称 | 参数类型 | 必填 | 备注 |
|----------|---------|--------|---------|-----|
| `code ` |返回码| `Integer` | 是 | 100正常 101程序异常 102  有必填字段为空|
| `message ` | 错误信息 | `String` | 否 | |
| `result ` | 返回结果 | `JSONArr` | 否 | |

- **result说明**：
- 
| 参数英文名 | 参数名称 | 参数类型 | 备注 |
|----------|---------|--------|-----|
| `data_source` |数据来源| `String` ||
| `event` | 事件 | `String` ||
| `event_type ` |事件类型| `String` ||
| `event_type_sub` | 事件类型子类 | `String` ||
| `personnel ` |人员| `String` ||
| `happen_time ` | 发生时间 | `datetime` ||
| sale_phone | 业务员号码 | String ||
| receipt_number | 单据编号 | String ||

##### 返回结果示例
```
{
    "code": 100,
    "result": [
        {
            "event_type_sub": "1",
            "event": "event_1",
            "event_type": "1",
            "personnel": "personnel1",
            "happen_time": 1582701698000,
            "sale_phone": "salePhone",
            "receipt_number": "receiptNumber"
        }
    ]
}
```


##### 请求方法 /crm/findInteractionCollecionList
- **方法介绍**：查询交互记录集合接口
- **调用方式**： `POST`
- **请求参数**：
- 
| 参数英文名 | 参数名称 | 参数类型 | 必填 | 备注 |
|----------|---------|--------|---------|-----|
| `creator` | 创建人| `String` | 是 | |
| `permission` | 权限 | `Integer` | 是 | 0: 自己本人;  3: 全公司|
| `eventType` | 事件类型 | `String ` | 否 | 01.常规，02.警告 |
| `queryObjIds ` | 查询对象集合 | `JSONArr` | 是 | |

- **queryObjIds 请求参数**：
- 
| 参数英文名 | 参数名称 | 参数类型 | 必填 | 备注 |
|----------|---------|--------|---------|-----|
| `visitId ` |拜访对象ID| `Long` | 是 | |
| `contactId ` | 联系人ID | `Long` | 否 | |

##### 方法解释
```
根据传入条件 permission = 0 时，默认查询创建人为传入 creator 账号； 
如果 permission = 3，则不过滤创建人的条件, 查询全部数据。
当查询对象集合 queryObjIds 中每个 contactId 为 0 时，则根据 visitId 查询联系人交互记录中最新的一条记录，
封装结果返回。 当查询对象集合 queryObjIds 中 contactId 不为 0 时，则根据 visitId + contactId 
作为 Key 键查询结果取最新一条记录封装返回。
```


##### 请求样例
```
http://172.24.121.142:8080/crm/findInteractionCollecionList
{
	"creator":"creator1",
	"permission":3,
	"eventType":"1",
	"queryObjIds":[
	{
		"contactId":202002201530445,
		"visitId":202002201530445
	}
		]
}
```
##### 返回结果
- **返回参数**：
- 
| 参数英文名 | 参数名称 | 参数类型 | 必填 | 备注 |
|----------|---------|--------|---------|-----|
| `code ` |返回码| `Integer` | 是 | 100正常 101程序异常 102  有必填字段为空|
| `message ` | 错误信息 | `String` | 否 | |
| `result ` | 返回结果 | `JSONArr` | 否 | |

- **result说明**：
- 
| 参数英文名 | 参数名称 | 参数类型 | 备注 |
|----------|---------|--------|-----|
| `visit_id ` |拜访对象ID| `Long` ||
| `contact_id ` | 联系人ID | `Long` ||
| `data_source ` | 数据来源 | `String` ||
| `personnel ` | 人员 | `String` ||
| `event ` | 事件 | `String` ||
| `event_type ` | 事件类型| `String` ||
| `event_type_sub ` | 事件类型子类 | `String` ||
| `happen_time ` | 发生时间 | `datetime` ||
| sale_phone | 业务员号码 | String ||
| receipt_number | 订单编号 | String ||

##### 返回结果示例
```
{
    "code": 100,
    "result": [
        {
            "data_source": "1",
            "visit_id": 202002201530445,
            "contact_id": 202002201530445,
            "event_type_sub": "1",
            "event": "event_1",
            "event_type": "1",
            "personnel": "personnel1",
            "happen_time": 1582128000000,
            "sale_phone": "salePhone",
            "receipt_number": "receiptNumber"
        }
    ]
}
```
##### 生产 kafka 中的数据格式如下
```json
{
    "creator":"zjx",
    "cDate":1582701698158,
    "contactId":202002201530445,
    "eventTypeSub":"1",
    "employeeId":"employeeId_1",
    "eventType":"1",
    "visitId":202002201530445,
    "unitId":"unitId_1",
    "personnel":"personnel1",
    "shopId":"shopId_1",
    "event":"event_1",
    "dataSource":"1",
    "happenTime":1582701698158,
    "salePhone":"salePhone",
    "receiptNumber":"receiptNumber"
}
```

##### 请求方法 /crm/consumeData
- **方法介绍**：消费 kafka 中的数据落地到 interactive_record 中
- **调用方式**： `GET`

###### 请求样例
```
从 kafka 中消费数据
http://localhost:8080/crm/consumeData

```

##### 请求方法 /crm/produceData
- **方法介绍**：向 kafka 中生产数据
- **调用方式**： `POST`
- **请求参数**：
- 
| 参数英文名 | 参数名称 | 参数类型 |
|----------|---------|--------|
| `creator` | 创建人| `String` |
| `cDate` | 创建时间 | `datetime` |
| `contactId` | 联系人ID | `Long ` |
| `eventTypeSub ` | 事件类型子类 | `String` |
| `employeeId ` | 雇员ID | `String` |
| `eventType ` | 事件类型 | `String ` |
| `visitId ` | 拜访对象ID | `Long` |
| `unitId ` | 所属事业部 | `String ` |
| `personnel ` | 人员 | `String ` |
| `shopId ` | 所属营业店 | `String ` |
| `event ` | 事件 | `String ` |
| `dataSource ` | 数据来源 | `String ` |
| `happenTime ` | 发生时间 | `datetime` |
| sale_phone | 业务员号码 | String |
| receipt_number | 订单编号 | String |



##### 请求样例
```
http://172.24.121.142:8080/crm/produceData
{
    "creator":"zjx",
    "cDate":1582701698158,
    "contactId":202002201530445,
    "eventTypeSub":"1",
    "employeeId":"employeeId_1",
    "eventType":"1",
    "visitId":202002201530445,
    "unitId":"unitId_1",
    "personnel":"personnel1",
    "shopId":"shopId_1",
    "event":"event_1",
    "dataSource":"1",
    "happenTime":1582701698158,
    "salePhone":"salePhone",
    "receiptNumber":"receiptNumber"
}
```

### 配置信息
```
测试环境
kafka信息：
开发kafka：172.24.121.200:9092
测试kafka：172.16.85.145:9092

mysql信息
database_name:crm_interactive
ip:172.24.121.219
port:3306
username:crm_interactive
password:crm_interactive123456 

生产环境
kafka信息：
172.24.104.137:9092,172.24.104.138:9092,172.24.104.139:9092

mysql信息
database_name:crm_interactive
ip:172.24.105.37
port:3306
username:crm_interactive
password:5_#nU~pKRdTfr*nr
```

### 项目技术点
```
1. 使用 springmvc 搭建 web 项目
2. 使用到 dbcp2 连接池技术
3. 使用 spring的jdbcTemplate与数据库交互

```
### 注意事项
```
1. 使用为 true 循环语句不停的扫描 kafka
2. 使用自己写的 kafka 封装类消费 kafka 中数据
```



