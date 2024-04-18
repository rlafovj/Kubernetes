import { createAsyncThunk } from "@reduxjs/toolkit"
import { findAllArticlesAPI, findArticleByBoardIdAPI } from "./article.api"

export const findAllArticles: any = createAsyncThunk('articles/findAllArticles',
    async(page: number) => {
        const data:any = await findAllArticlesAPI(page)
        const {message, result}:any = data
        
        return data
    }
)

export const findArticleByBoardId: any = createAsyncThunk('articles/findArticleByBoardId',
    async({page, id}: any) => {
        await findArticleByBoardIdAPI(page, id)
    }
)