import { createAsyncThunk } from "@reduxjs/toolkit"
import { findAllArticlesAPI } from "./article.api"

export const findAllArticles: any = createAsyncThunk('articles/findAllArticles',
    async(page: number) => {
        const data:any = await findAllArticlesAPI(page)
        const {message, result}:any = data
        
        return data
    }
)