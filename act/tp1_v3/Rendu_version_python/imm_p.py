#!/usr/bin/env python
import os
import copy


def get_point(FileName):

    points=[]
    right_bound=0
    max_height=0
    
    with open(FileName,'r') as f:    ##获取线段的方法，读取文件中的线段，并且利用split方法把每个线段分为左坐标，高度，右坐标，放在队列中
        s=f.read().split('\n')
    lines=int(s[0])
    for i in range(1,lines+1):
        l = []
        for item in s[i].split(' '):
            l.append(int(item))
        points.append(l)
        max_height=max(max_height,l[1])
        right_bound=max(right_bound,l[2])
    result=[[0 for j in range(0,right_bound+2)]
    for i in range(0,max_height+2)]
    points.sort()
    for point in points:
        for i in range(point[0],point[2]+1):
            for j in range(0,point[1]+1):
                result[j][i]=1   #一维数组是宽，二维数组是长

    return result
    
def scan(points):         #利用获取最大范围获取图形基本轮廓
    result=[]

    for j in range(0,len(points[0])):  #这个方法就是获取最上面的一层的1的方法   j取的是二维数组(长)
        for i in range(0,len(points)):  #自下而上开始扫描                     i 取得是一维数组(宽)
            if points[i][j]==0:           #扫描到第一层的零点

                if i!=0:
                    result.append([j,i-1])      #当我们的零点的x坐标不是0的时候，往下压一层，这样就能把最高层的1包进去

                else:
                    result.append([j,i])   #零点的x坐标是零的时候全部加进去

                break

    copy_result1 = result
    copy_result=[]

    for index,point in enumerate(result[1:]):

            if result[index][1]!=point[1] or result[index][0]!=point[0]:##前一个点和后一个点不在同一列或者不在同一行
                if result[index][1]<point[1]:               ##前一个点比后一个点低
                    copy_result.append([point[0],result[index][1]])   ##做一个点，横坐标是后一个点，纵坐标是前一个点(咯吱窝点)
                    copy_result.append(point)                   ##后一个点照旧加上
                else:
                    copy_result.append(result[index])  ##前一个点比后一个点高或者一样高
                    copy_result.append([result[index][0],point[1]]) # 做一个点，横坐标是前一个点，纵坐标是后一个点（咯吱窝点）


    result=[]
    tem=[[] for i in range(len(copy_result))]    #同样比较前一个点与后一个点
    tem[0].append(copy_result[0])
    count_i=1
    for index , point in enumerate(copy_result[1:]):   #如果前面的点和后面的点高度不一致，把这个点放在别的队列中（tem,队列数加一）
        if copy_result[index][1]!=point[1]:
            tem[count_i+1].append(point)
            count_i+=1
        else:
            tem[count_i].append(point)                  #现在我们获取的不同高度的几组点
            
    for item in tem[1:]:          #这个方法就是用来获取每一层的最左最右点，item[0] 是最左边 item[-1]是最右边（python有获取队列最尾端的方法）
       
        if len(item)==1:
            result.append(item[0])
        elif len(item)>1:
            result.append(item[0])
            result.append(item[-1])
        
    
    return result[1:]
    
def out(result,FileName):
    
    with open(FileName,'w') as f:
        for item in result:
            f.write('{},{} '.format(item[0],item[1]))
        
if __name__=='__main__':
    FileName='Imm4'
    points=get_point(FileName)
    print('*********')

    result=scan(points)
    print(result)
    
    out(result,FileName+'data.txt')
