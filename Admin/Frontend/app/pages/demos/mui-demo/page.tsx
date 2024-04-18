'use client'

import * as React from 'react';
import Box from '@mui/material/Box';
import { DataGrid, GridColDef } from '@mui/x-data-grid';
import MuiDemoRows from '@/app/components/rows/mui-demo-rows';
import MuiDemoColumns from '@/app/components/demos/mui-demo-columns';
import { NextPage } from 'next';

const DataGridDemoPage : NextPage = () => {
  return (
    <Box sx={{ height: 400, width: '100%' }}>
      <DataGrid
        rows={MuiDemoRows()}
        columns={MuiDemoColumns()}
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
      />
    </Box>
  );
}

export function test(){

}

export default DataGridDemoPage