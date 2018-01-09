import os
import copy


def s2num(s):
    # 输入 '10 20 30'
    # 输出 [10,20,30]  字符串到整数
    names=locals()
    l=[]
    for item in s.split(' '):
       l.append(int(item)) 
    return l
    
def get_point(FileName):
    # 输入文件名
    # 输出其中像素矩阵
    
    points=[]
    left_bound=0
    right_bound=0
    max_height=0
    
    with open(FileName,'r') as f:
        s=f.read().split('\n')
    lines=int(s[0])
    
    for i in range(1,lines+1):
        l=s2num(s[i])
        points.append(l)
        max_height=max(max_height,l[1])
        right_bound=max(right_bound,l[2])
    
    result=[[0 for j in range(0,right_bound+2)] for i in range(0,max_height+2)]
    points.sort()
    for point in points:
        for i in range(point[0],point[2]+1):
            for j in range(0,point[1]+1):
                result[j][i]=1   #被占据
    # for item in result:
        # print(item,'itrm')
    return result
    
def scan(points):
    result=[]
    for j in range(0,len(points[0])):
        for i in range(0,len(points)):
            if points[i][j]==0:
                if i!=0:
                    result.append([j,i-1])
                else:
                    result.append([j,i])
                break
                
    copy_result=[]
    for index,point in enumerate(result[1:]):
        if result[index][1]!=-1:
            if result[index][1]!=point[1] or result[index][0]!=point[0]:
                if result[index][1]<point[1]:
                    copy_result.append([point[0],result[index][1]])
                    copy_result.append(point)
                else:
                    copy_result.append(result[index])
                    copy_result.append([result[index][0],point[1]])
            else:
                copy_result.append(result[index])
        try:
            # print(copy_result[-1])
            pass
        except:
            pass
    # copy_result.insert(0,[copy_result[0][0],0])
    # copy_result.append([copy_result[-1][0],0])
    result=[]
    tem=[[] for i in range(len(copy_result))]
    tem[0].append(copy_result[0])
    count_i=1
    for index , point in enumerate(copy_result[1:]):
        if copy_result[index][1]!=point[1]:
            tem[count_i+1].append(point)
            count_i+=1
        else:
            tem[count_i].append(point)
            
    for item in tem[1:]:
        # print(item)
        if len(item)==1:
            result.append(item[0])
        elif len(item)>1:
            result.append(item[0])
            result.append(item[-1])
        
    
    return result[1:]
    
def out(result,FileName):
    # 输入结果,文件名 将生成的坐标写入到文件
    with open(FileName,'w') as f:
        for item in result:
            f.write('{},{} '.format(item[0],item[1]))
        
if __name__=='__main__':
    FileName='Imm100'   #处理哪个文件
    points=get_point(FileName)
    print('*********')
    
    result=scan(points)
    print(result)
    
    # out(result,FileName+'data.txt')