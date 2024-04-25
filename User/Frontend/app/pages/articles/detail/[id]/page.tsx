'use client'

import { useRouter } from "next/navigation"
import { DataGrid } from '@mui/x-data-grid';
import { useState, useEffect } from "react"
import {Box, Button, Input} from '@mui/material';
import { useSelector, useDispatch } from 'react-redux'
import { NextPage } from "next";
import { getArticleByBoardId } from '@/redux/features/articles/article.slice'
import { findArticleByBoardId } from '@/redux/features/articles/article.service'
import { IArticle } from "@/redux/features/articles/article.model";
// import React from "react";

export default function ArticleDetail({params}:any){

const dispatch = useDispatch()
const article:IArticle = useSelector(getArticleByBoardId)

useEffect(()=>{dispatch(findArticleByBoardId(params.id))},[])

    return(<>
    <h2>{params.id}상세 페이지</h2>
    {article}
    </>)
}