from fastapi import APIRouter
from pydantic import BaseModel

from app.api.titanic.service.titanic_service_py import TitanicService

router = APIRouter()
service = TitanicService()


class Request(BaseModel):
    question: str

class Response(BaseModel):
    answer: str

@router.post("/titanic")
async def titanic(req: Request):
    print('타이타닉 딕셔너리 내용')
    hello = 'C:\\Users\\bitcamp\\Kubernetes\\Chat\\Backend\\app\\api\\titanic\\data\\hello.txt'
    f = open(hello, 'r', encoding='utf-8')
    data = f.read()
    print(data)
    f.close()

    service.process()
    print(req)
    print(service.process())

    return {"answer": "1000명"}
