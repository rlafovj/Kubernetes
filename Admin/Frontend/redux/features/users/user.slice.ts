import {createSlice} from '@reduxjs/toolkit'
import { initialState } from './user.init'
import { findAllUsers, login } from './user.service'
import { IUser } from './user.model'

const status = {
    pending: "pending",
    fulfilled: "fulfilled",
    rejected: "rejected"
}

interface IAuth{
    message?: string,
    token?: string
}

interface UserState {
    array? : Array<IUser>,
    json? : IUser,
    auth? : IAuth
}

export const inintialState: UserState = {
    array: [],
    json: {} as IUser,
    auth: {} as IAuth

}

const handlePending = ()=>{

}
const handleFulfilled = (state: any,{payload}:any)=>{
    console.log("---------------conclusion--------------")
    state.array = payload
    console.log(JSON.stringify(payload))
}
const handleRejected = ()=>{

}

export const userSlice = createSlice({
    name: "user",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const {pending, rejected} = status;

    builder
    .addCase(findAllUsers.fulfilled, (state: any, {payload}:any )=>{state.array=payload})
    .addCase(login.fulfilled, (state: any, {payload}:any )=>{state.auth=payload})
    }
})

export const AllUsers = (state:any)=>{
    console.log('------------------Before useSelector--------------------')
    return state.user.array;
}
export const getAuth = (state: any) => (
    // console.log('------------------ Before Login useSelector ---------------')
    // console.log(JSON.stringify(state.user.message))
    state.user.auth)
  

export const {} = userSlice.actions
export default userSlice.reducer