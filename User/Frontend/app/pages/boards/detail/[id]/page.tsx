'use client'


import { IBoard } from "@/redux/features/boards/board"
import { findAllBoards, findBoardById } from "@/redux/features/boards/board.service"
import { getBoardById } from "@/redux/features/boards/board.slice"
import { Typography } from "@mui/material"
import { useEffect } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"

export default function BoardDetailPage (props:any){

    const dispatch = useDispatch()
    const board:IBoard=useSelector(getBoardById)

    useEffect(()=>{
        dispatch(findBoardById(props.params.id))
    }, [])

    return(<>

    {props.params.id}번 게시판 상세
    <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{props.params.id}</Typography>
    <span>게시판이름 : </span><Typography textAlign="center" sx={{fontSize:"1.5rem"}}></Typography>
    <span>게시판타입 : </span><Typography textAlign="center" sx={{fontSize:"1.5rem"}}></Typography>
    <span>등록일 : </span><Typography textAlign="center" sx={{fontSize:"1.5rem"}}></Typography>
    <span>수정일 : </span><Typography textAlign="center" sx={{fontSize:"1.5rem"}}></Typography>


    </>)
}