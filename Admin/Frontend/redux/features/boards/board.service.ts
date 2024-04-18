import { createAsyncThunk } from "@reduxjs/toolkit"
import { findAllBoardsAPI, findBoardByIdAPI } from "./board.api"


export const findAllBoards: any = createAsyncThunk('board/findAllBoards',
async(page: number) => 
    await findAllBoardsAPI(page)
    
)
export const findBoardById: any = createAsyncThunk('board/findBoardById',
    async(id: number)=> await findBoardByIdAPI(id)
)