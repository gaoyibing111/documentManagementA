
    function chooseUrl(url,_vcrList){

        switch (url){
            case  "queryVehicleChangeRecord":
                queryVehicleChangeRecord(_vcrList);
                break;
            case  "queryFuelTestingRecord":
                queryFuelTestingRecord(_vcrList);
                break;
            case  "querySecondMaintenanceRecords":
                querysecondMaintenanceRecords(_vcrList);
                break;
            case  "queryVehicleDetectionRecords":
                queryvehicleDetectionRecords(_vcrList);
                break;
            case  "queryCertificateReceivingRecords":
                queryCertificateReceivingRecords(_vcrList);
                break;
            case  "queryRoutineMaintenanceRecords":
                queryRoutineMaintenanceRecords(_vcrList);
                break;

            default: break;
        }
    }






//查看车辆变更记录
function queryVehicleChangeRecord(_vcrList){
    var dataArray=eval(_vcrList);
    var aaa="";
    for(var i in dataArray)
    {
        aaa+="<tr>";
        aaa+="<td>"+dataArray[i].plateNumber+"</td>";
        aaa+="<td>"+dataArray[i].hassisNumber+"</td>";
        aaa+="<td>"+dataArray[i].carGenusUnit+"</td>";
        aaa+="<td>"+dataArray[i].changeContent+"</td>";
        aaa+="<td>"+dataArray[i].reviewStatus+"</td>";
        aaa+="<tr/>";
    }
    $('#changeRecordTr').html(aaa);
}



/**
 *  查询燃油检测记录接口
 */
    function queryFuelTestingRecord(_vcrList){
        var dataArray=eval(_vcrList);
        var aaa="";
        for(var i in dataArray)
        {
            aaa+="<tr>";
            aaa+="<td>"+dataArray[i].plateNumber+"</td>";
            aaa+="<td>"+dataArray[i].chassisNumber+"</td>";
            aaa+="<td>"+dataArray[i].carGenusUnit+"</td>";
            aaa+="<td>"+dataArray[i].sendCheckPeople+"</td>";
            aaa+="<td>"+dataArray[i].detectionUnit+"</td>";
            aaa+="<td>"+dataArray[i].detectionTime+"</td>";
            aaa+="<td>"+dataArray[i].reviewStatus+"</td>";
            aaa+="<td><a style=\"cursor:pointer\">查看详情<a/></td>";
            aaa+="<tr/>";
        }
        $('#fuelTestingRecordTr').html(aaa);
    }


    function  addRoutineMaintenanceRecords(){

        document.getElementById("dlag_edit").style.display="block";
    }

    function close_dialog(){
        document.getElementById("dlag_edit").style.display="none";
    }
