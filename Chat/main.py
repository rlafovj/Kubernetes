from fastapi import FastAPI
from langchain_openai import OpenAI
from langchain_community.chat_models import ChatOpenAI
import os
from dotenv import load_dotenv

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
load_dotenv(os.path.join(BASE_DIR, ".env"))

llm = OpenAI(openai_api_key="...")

app = FastAPI()

@app.get("/")
async def root():
    api_key = os.environ["api_key"]
    chat_model = ChatOpenAI(openai_api_key=os.environ["api_key"])

    result = chat_model.predict("8월에 여행가기 좋은 아시아권 도시들을 이유와 함께 추천해줘")
    print(result)
    return {"message": "Hello World"}

@app.get("/hi")
async def root():
    return {"message": "Hi World"}