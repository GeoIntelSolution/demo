## 单路口监控/多路口监控
1.快速进入编辑窗口：
(1).在地图上点击相关的图标，通过菜单进入相关信号灯的窗口
(2).就是对marker图层的右键菜单点击事件中添加相关逻辑
(3).相关的marker图标上面有左键弹窗/右键菜单/双击高亮等
多个点击事件，存在相关的操作bug.(可能是popup的逻辑问题)
2.通过地图模式关联相关的设备
(1).一个缓冲区查询获取某个中心点周围的设备，并打点即可
(2).相关设备的常规属性编辑/空间位置的编辑
(3).相关地图坐标系的等级(3857 18 1px=0.59m)
   3.75*4=16  16/0.59= 27px  是不是能看的清
   
   
3.收藏夹的问题
？