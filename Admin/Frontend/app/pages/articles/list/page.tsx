'use client'
import axios from "axios";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";
import Box from '@mui/material/Box';
import { DataGrid, GridColDef, GridRowSelectionModel } from '@mui/x-data-grid';
import {Button, Input} from '@mui/material'
import { API } from "@/redux/common/enums/API";
import AxiosConfig from "@/redux/common/configs/axios-config";
import MuiDemoRows from "@/app/components/rows/mui-demo-rows";
import MuiDemoColumns from "@/app/components/demos/mui-demo-columns";
import { NextPage } from "next";
import { findAllArticles } from "@/redux/features/articles/article.service";
import { getAllArticles } from "@/redux/features/articles/article.slice"
import { useDispatch } from "react-redux"
import { useSelector } from "react-redux";
import { IArticle } from "@/redux/features/articles/article.model";
import Columns from "@/app/components/articles/ArticleColumns";
import ArticlesColumns from "@/app/components/articles/ArticleColumns";

const ArticlesPage : NextPage = ({data}:any) => {
    const router = useRouter();
    const dispatch = useDispatch()
    // const [articles, setArticles] = useState([]) //state는 redux에서 처리했기 때문에 react에서 useState할 필요가 없음
    const allArticles: [] = useSelector(getAllArticles)
    const [selectedRows, setSelectedRows] = useState<GridRowSelectionModel>([]);

    if(allArticles !== undefined){
      console.log('allArticles is not undefined')
      
      console.log('length is '+ allArticles.length)
      for(let i=0; i< allArticles.length; i++){
          console.log(JSON.stringify(allArticles[i]))
      }
  }else{
      console.log('allArticles is undefined')
  }

  useEffect(()=>{
    dispatch(findAllArticles())
  }, [])

  const handleDelete = async () => {
    await Promise.all(selectedRows.map(id => axios.delete(`http://localhost:8080/api/articles/delete/${id}`)));
    dispatch(findAllArticles(1));
};
    return (<>
        <h2>게시글 목록</h2>
        <span className="text-3xl justify-center flex">게시글 수 : {allArticles.length}</span>
            <br/>
            <Button onClick={handleDelete}>삭제</Button>
        <Box sx={{ height: '100%', width: '100%' }}>
      {allArticles && <DataGrid
        rows={allArticles}
        columns={ArticlesColumns()}
        onRowSelectionModelChange={(newSelection) => {
          setSelectedRows(newSelection);
        }}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 5,
            },
          },
        }}
        pageSizeOptions={[5]}
        checkboxSelection
        disableRowSelectionOnClick
      />}
    </Box>
    </>)
}

export default ArticlesPage