import { createSlice } from "@reduxjs/toolkit";
import { initialState } from "./article.init";
import {IArticle} from './article.model'
import { findAllArticles } from "./article.service";
import { findAllArticlesAPI } from "./article.api";

const articleThunks = [findAllArticles]

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
    }
  }
)

export const getAllArticles = (state: any) => {
  console.log('------------------ Before useSelector ---------------')
  console.log(JSON.stringify(state.article.array))
  return state.article.array;
}

export const {} = articleSlice.actions
export default articleSlice.reducer