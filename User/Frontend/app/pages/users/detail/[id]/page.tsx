'use client'

import { useRouter } from "next/navigation"
import { DataGrid } from '@mui/x-data-grid';
import { useState, useEffect } from "react"
import {Box, Button, Input} from '@mui/material';
import { useSelector, useDispatch } from 'react-redux'
import { NextPage } from "next";
import { IUser } from "@/redux/features/users/user.model";
import { getUserById } from "@/redux/features/users/user.slice";
import { findUserById } from "@/redux/features/users/user.service";

export default function UserDetail({params}:any){
    const dispatch = useDispatch()
    const user:IUser = useSelector(getUserById) 
    useEffect(()=>{
        dispatch(findUserById(params.id))
    },[]) 

    return(<>
    {user.id}
    {user.username}
    {user.password}
    {user.job}

    
    </>);
}