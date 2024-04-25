import { createAsyncThunk } from "@reduxjs/toolkit";
import { existsUsernameAPI, findAllUsersAPI, findUserByIdAPI, loginAPI, logoutAPI } from "./user.api";
import { IUser } from "./user.model";

export const findAllUsers: any = createAsyncThunk('users/findAllUsers',
async(page: number) => {
    const data:any = await findAllUsersAPI(page)
    const {message, users}:any = data
    return data
    }
)
export const login: any = createAsyncThunk('users/login',
async (user: IUser) => await loginAPI(user)

// (userCredentials: { username: string; password: string; }) => {
//     const data:any = await loginAPI(userCredentials)
//     const message:any = data
//     console.log(message)
//     return message
//     }
)
export const existsUsername: any = createAsyncThunk('users/existsUsername', async (username: string) => await existsUsernameAPI(username)
)
export const findUserById: any = createAsyncThunk(
    'users/findUserById',
    async (id: number)=> await  findUserByIdAPI(id)
)
export const logout: any = createAsyncThunk(
    'users/logout',
    async () => await logoutAPI()
)