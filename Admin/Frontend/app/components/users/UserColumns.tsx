import { Typography } from "@mui/material"
import {GridColDef} from "@mui/x-data-grid"
import { UserColumns } from "./model/columns"

interface Celltype{
    row : UserColumns
}

export default function UsersColumns(): GridColDef[]{
    return ([{
        flex: 0.0,
        minWidth: 30,
        sortable: false,
        field: 'id',
        headerName: 'No.',
        renderCell: ({row}:Celltype) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.id}</Typography>
        
    },
    {
        flex: 0.0,
        minWidth: 30,
        sortable: false,
        field: 'username',
        headerName: 'ID',
        renderCell: ({row}:Celltype) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.username}</Typography>
    },
    {
        flex: 0.0,
        minWidth: 30,
        sortable: false,
        field: 'password',
        headerName: '비밀번호',
        renderCell: ({row}:Celltype) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.password}</Typography>
    },
    {
        flex: 0.0,
        minWidth: 30,
        sortable: false,
        field: 'name',
        headerName: '이름',
        renderCell: ({row}:Celltype) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.name}</Typography>
    },
    {
        flex: 0.0,
        minWidth: 30,
        sortable: false,
        field: 'phone',
        headerName: '전화번호',
        renderCell: ({row}:Celltype) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.phone}</Typography>
        
    },
    {
        flex: 0.0,
        minWidth: 30,
        sortable: false,
        field: 'job',
        headerName: '직업',
        renderCell: ({row}:Celltype) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>  {row.job}</Typography>
    }])
}