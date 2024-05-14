from app.api.context.domains import DataSets


class Models:
    def __init__(self):
        self.ds = DataSets()
        this = self.ds
        this.dname = './data'
        this.sname = './save'