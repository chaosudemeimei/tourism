package com.juzheng.smart.tourism.util;

import lombok.Getter;
/**

 *
 * @author juzheng
 * @since 2019-05-01
 * //热门城市枚举类型
 */
@Getter
public enum HotCity{
/*beijingshi("北京市"),
shanghaishi("上海市"),*/
guangzhoushi("广州市"),
shenzhenshi("南京市"),
hangzhoushi("杭州市"),
xianshi("西安市"),
chengdushi("成都市"),
nanjingshi("南京市"),
suzhoushi("苏州市"),
qingdaoshi("青岛市"),
xiamenshi("厦门市"),
lasashi("拉萨市"),
;

private String city_name;
    HotCity( String city_name) {
this.city_name=city_name;
}
}
