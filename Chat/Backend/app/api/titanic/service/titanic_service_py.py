from icecream import ic

from app.api.titanic.model.titanic_model import TitanicModel
import pandas as pd
import numpy as np

class TitanicService:

    model = TitanicModel()
    # def process(self):
    #     print("프로세스 시작")
    #     this = self.model
    #     this.train = self.new_model('train.csv')
    #     this.test = self.new_model('test.csv')
    #     print(f"트레인 컬럼 : {this.train.columns}")
    #     print(f"테스트 컬럼 : {this.test.columns}")
    #     this.id = this.test['PassengerId']
    #     this = self.drop_feature(this, 'Name', 'Cabin', 'Ticket')
    #     print(f"트레인 컬럼2 : {this.train.columns}")
    #     print(f"테스트 컬럼2 : {this.test.columns}")
    #
    #     this = self.create_train(this)
    #
    # def df_info(this):
    #     [print(f'{i.head(3)}') for i in [this.train, this.test]] #리스트 컨프리헨션
    #     # for i in [this.train, this.test]:
    #     #     print(f'{i.info()}')
    # def new_model(self, payload) -> object:
    #     this = self.model
    #     this.context = './app/api/titanic/data/'
    #     this.fname = payload
    #     return pd.read_csv(this.context + this.fname)
    #
    # @staticmethod
    # def create_train(this) -> str:
    #     return this.train.drop('Survived', axis=1) #0 열 1 행
    #
    # @staticmethod
    # def create_label(this) -> str:
    #     return this.train['Survived']
    #
    # @staticmethod
    # def drop_feature(this, *feature) -> pd.DataFrame:
    #     for i in feature:
    #         this.train = this.train.drop([i], axis=1)
    #         this.test = this.test.drop([i], axis=1)
    #
    #     # for i in [this.train, this.test]:
    #     #     for j in feature:
    #     #         i.drop(j, axis=1, inplace=True)
    #     #
    #     # [i.drop(j, axis=1, inplace=True) for i in feature for j in [this.train, this.test]]
    #     #inplace = True : 원본을 변경하겠다
    #     return this
    #
    # @staticmethod
    # def extract_title_from_name(this) -> pd.DataFrame:
    #     combine = [this.train, this.test]
    #     for i in combine:
    #         i['Title'] = i['Name'].str.extract(' ([A-Za-z]+)\.')
    #     return this
    #
    # @staticmethod
    # def remove_duplicate_title(this) -> pd.DataFrame:
    #     a = []
    #     for these in [this.train, this.test]:
    #         a += list(set(these['Title']))
    #     a = list(set(a))
    #     print(a)
    #     '''
    #     ['Mr', 'Sir', 'Major', 'Don', 'Rev', 'Countess', 'Lady', 'Jonkheer', 'Dr',
    #     'Miss', 'Col', 'Ms', 'Dona', 'Mlle', 'Mme', 'Mrs', 'Master', 'Capt']
    #     Royal : ['Countess', 'Lady', 'Sir']
    #     Rare : ['Capt','Col','Don','Dr','Major','Rev','Jonkheer','Dona','Mme' ]
    #     Mr : ['Mlle']
    #     Ms : ['Miss']
    #     Master
    #     Mrs
    #     '''
    #     title_mapping = {'Mr': 1, 'Ms': 2, 'Mrs': 3, 'Master': 4, 'Royal': 5, 'Rare': 6}
    #     return title_mapping
    #
    # @staticmethod
    # def title_nominal(this, title_mapping) -> pd.DataFrame:
    #     for these in [this.train, this.test]:
    #         these['Title'] = these['Title'].replace(['Countess', 'Lady', 'Sir'], 'Royal')
    #         these['Title'] = these['Title'].replace(
    #             ['Capt', 'Col', 'Don', 'Dr', 'Major', 'Rev', 'Jonkheer', 'Dona', 'Mme'], 'Rare')
    #         these['Title'] = these['Title'].replace(['Mlle'], 'Mr')
    #         these['Title'] = these['Title'].replace(['Miss'], 'Ms')
    #         # Master 는 변화없음
    #         # Mrs 는 변화없음
    #         these['Title'] = these['Title'].fillna(0)
    #         these['Title'] = these['Title'].map(title_mapping)
    #     return this
    #
    # @staticmethod
    # def age_ratio(this) -> pd.DataFrame:
    #     train = this.train
    #     test = this.test
    #     age_mapping = {'Unknown': 0, 'Baby': 1, 'Child': 2, 'Teenager': 3, 'Student': 4,
    #                    'Young Adult': 5, 'Adult': 6, 'Senior': 7}
    #     train['Age'] = train['Age'].fillna(-0.5)
    #     test['Age'] = test['Age'].fillna(-0.5)  # 왜 NaN 값에 -0.5 를 할당할까요 ?
    #     bins = [-1, 0, 5, 12, 18, 24, 35, 60, np.inf]  # 이것을 이해해보세요
    #     labels = ['Unknown', 'Baby', 'Child', 'Teenager', 'Student', 'Young Adult', 'Adult', 'Senior']
    #
    #     for these in train, test:
    #         pass #pd.cut()
    #         these['Age'] = pd.cut(these['Age'], bins, labels=labels)
    #         these['AgeGroup'] = these['Age'].map(age_mapping)
    #     return this
    #
    # def __init__(self) -> None:
    #     self.model = TitanicModel()

    def preprocess(self):
        ic(f'전처리 시작')
        self.model.preprocess('train.csv', 'test.csv')


    def modeling(self):
        ic(f'모델링 시작')
        this = self.model

    def learning(self):
        ic(f'학습 시작')
        ic(f'결정트리를 활용한 검증 정확도: ')
        ic(f'랜덤프레스트를 활용한 검증 정확도: ')
        ic(f'나이브베이즈를 활용한 검증 정확도: ')
        ic(f'KNN를 활용한 검증 정확도: ')
        ic(f'SVM를 활용한 검증 정확도: ')
        this = self.model


    def postprocessing(self):
        ic(f'후처리 시작')
        this = self.model

    def submit(self):
        ic(f'제출 시작')
        this = self.model