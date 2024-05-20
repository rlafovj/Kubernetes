from fastapi import APIRouter
from icecream import ic
from pydantic import BaseModel
CONTEXT = 'C:\\Users\\bitcamp\\Kubernetes\\Chat\\Backend\\app\\api\\context'

from app.api.titanic.service.titanic_service_py import TitanicService

router = APIRouter()
service = TitanicService()


class Request(BaseModel):
    question: str

class Response(BaseModel):
    answer: str

@router.post("/titanic")
async def titanic(req: Request):
    ic('타이타닉 딕셔너리 내용.')
    hello = f'{CONTEXT}data\\hello.txt'
    f = open(hello, "r", encoding="utf-8")
    data = f.read()
    ic(data)
    f.close()
    service.preprocess()
    ic(req)
    return {"answer": "1000명"}
