import pandas as pd
from app.api.context.domains import DataSets


class Models:
    def __init__(self) -> None:
        self.ds = DataSets()
        this = self.ds
        this.dname = './data'
        this.sname = './save'
    def new_model(self, fname) -> object:
        this = self.ds
        # index_col=0 -> 기존 index 값이 유지,
        # 0은 컬럼명 중에서 첫번째를 의미
        # 여기서는  PassengerId가 index로 들어가게 된다.
        # pd.read_csv(f'경로/파일명/csv', index_col=0) 여기서 0대신에 1넣으면 2번째 컬럼명이 index로 들어간다.
        return pd.read_csv(f'{this.dname}{fname}',index_col=0)
    def new_dframe(self, fname) -> object:
        this = self.ds
        return pd.DataFrame(pd.read_csv(f'{this.dname}{fname}'))
    def save_model(self,fname,dname) -> object:
        this = self.ds
        '''
        풀옵션은 다음과 같다
        df.to_csv(f'{self.ds.sname}{fname}',sep=',',na_rep='NaN',
                         float_format='%.2f',  # 2 decimal places
                         columns=['ID', 'X2'],  # columns to write
                         index=False)  # do not write index
        '''
        return dname.to_csv(f'{this.sname}{fname}',sep=',',na_rep='NaN')
