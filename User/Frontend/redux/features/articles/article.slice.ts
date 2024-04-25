import { createSlice } from "@reduxjs/toolkit";
import {IArticle} from './article.model'
import { findAllArticles, findArticleByBoardId } from "./article.service";
import { findAllArticlesAPI } from "./article.api";

const articleThunks = [findAllArticles]

interface IArticleState{
  json?: IArticle,
  array?: Array<IArticle>,
  count?: number
}

export const initialState: IArticleState = {
  json: {} as IArticle,
  array: [],
  count: 0
}

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}

const handlePending = (state : any) => {
    
}

const handleFulfilled = (state:any,{payload}:any) => {
    console.log('-------------------conclusion-------------------')
    state.array = payload
    console.log(JSON.stringify(payload))
  }

const handleRejected = (state : any) => {
    
}

export const articleSlice = createSlice({
    name: "article",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const {pending,rejected} = status;

    builder
      .addCase(findAllArticles.fulfilled,handleFulfilled)
      .addCase(findArticleByBoardId.fulfilled,  (state: any, {payload}: any) => {state.json = payload})
    }
  }
)

export const getAllArticles = (state: any) => {
  console.log('------------------ Before useSelector ---------------')
  console.log(JSON.stringify(state.article.array))
  return state.article.array;
}
export const getArticleByBoardId = (state: any) => (state.article.json)

export const {} = articleSlice.actions
export default articleSlice.reducer