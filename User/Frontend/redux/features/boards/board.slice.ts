import { createSlice } from "@reduxjs/toolkit";
import { initialState } from "./board.init";
import {IBoard} from './board'
import { findAllBoards, findBoardById } from "./board.service";
import { findAllBoardsAPI } from "./board.api";

const boardThunks = [findAllBoards,findBoardById]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}

const handlePending = (state : any) => {
    
}

const handleFulfilled = (state:any,{payload}:any) => {
    console.log('-------------------conclusion-------------------')
    console.log(payload)
    state.array = payload
    console.log(JSON.stringify(payload))
  }

const handleRejected = (state : any) => {
    
}

export const boardSlice = createSlice({
    name: "board",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const {pending,rejected} = status;

    builder
      .addCase(findAllBoards.fulfilled, handleFulfilled)
      .addCase(findBoardById.fulfilled,(state: any, {payload}:any )=>{state.json=payload})
    }
  }
)

export const getAllBoards = (state: any) => {
  console.log('------------------ Before useSelector ---------------')
  console.log(JSON.stringify(state.board.array))
  return state.board.array;
}
export const getBoardById = (state: any) => 
  (state.board.json)


export const {} = boardSlice.actions
export default boardSlice.reducer