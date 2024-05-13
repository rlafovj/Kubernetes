from fastapi import FastAPI
from langchain_openai import OpenAI
from langchain_community.chat_models import ChatOpenAI
from langchain.schema import SystemMessage, HumanMessage, AIMessage
from pydantic import BaseModel
import os
from dotenv import load_dotenv
from starlette.middleware.cors import CORSMiddleware
from app.api.titanic.model.titanic_model import TitanicModel
from app.api.titanic.main_router import router

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
load_dotenv(os.path.join(BASE_DIR, ".env"))


class Request(BaseModel):
    question: str


class Response(BaseModel):
    answer: str


app = FastAPI()

app.include_router(router, prefix="/api")

origins = ["*"]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


@app.get("/")
def root():
    return {"message": "Hello World"}


#@app.post("/chat")
def chatting(req: Request):
    print('딕셔너리 내용')
    print(req)

    chat = ChatOpenAI(
        openai_api_key=os.environ["api_key"],
        temperature=0.1,  # 창의성 (0.0 ~ 2.0)
        max_tokens=2048,  # 최대 토큰수
        model_name='gpt-3.5-turbo-0613',  # 모델명
    )

    # 질의
    print(f'{chat.predict(req.question)}')

    # message = [
    #     SystemMessage(content="You are a traveler. You know the capitals of every country in the world.",
    #                   type="system"),
    #     HumanMessage(content="한국의 수도는 어디야 ? ", type="human"),
    #     AIMessage(content="한국의 수도는 서울 입니다.", type="ai"),
    # ]

    # print(chat.predict_messages(message))

    return Response(answer=chat.predict(req.question))
