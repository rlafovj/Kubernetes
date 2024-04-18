import { Typography } from "@mui/material";
import { GridColDef } from "@mui/x-data-grid";
import { ArticleColumns } from "./model/columns";

interface CellType{
    row:ArticleColumns
}

export default function ArticlesColumns(): GridColDef[]{

    return [
        {
            flex: 0.0,
            minWidth: 30,
            sortable: false,
            field: 'id',
            headerName: 'No.',
            renderCell: ({row}:CellType) =>  <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.id}</Typography>
        },
        {
            flex: 0.0,
            minWidth: 30,
            sortable: false,
            field: 'title',
            headerName: '제목',
            renderCell: ({row}:CellType) =>  <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.title}</Typography>
        },
        {
            flex: 0.0,
            minWidth: 30,
            sortable: false,
            field: 'content',
            headerName: '내용',
            renderCell: ({row}:CellType) =>  <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.content}</Typography>
        },
        {
            flex: 0.0,
            minWidth: 30,
            sortable: false,
            field: 'writer',
            headerName: '글쓴이',
            renderCell: ({row}:CellType) =>  <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.writer}</Typography>
        },
        {
            flex: 0.0,
            minWidth: 30,
            sortable: false,
            field: 'registerDate',
            headerName: '등록일',
            renderCell: ({row}:CellType) =>  <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.registerDate}</Typography>
        },
    ]
}