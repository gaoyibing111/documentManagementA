
    function chooseUrl(url,_vcrList){

        switch (url){
            case  "queryVehicleChangeRecord":
                queryVehicleChangeRecord(_vcrList);
                break;
            case  "queryFuelTestingRecord":
                queryFuelTestingRecord(_vcrList);
                break;
            case  "querySecondMaintenanceRecords":
                querySecondMaintenanceRecords(_vcrList);
                break;
            case  "queryVehicleDetectionRecords":
                queryVehicleDetectionRecords(_vcrList);
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
    /**
     * 查询二级维护记录接口
     */

        function  querySecondMaintenanceRecords(_vcrList){
        var dataArray=eval(_vcrList);
        var aaa="";
        for(var i in dataArray)
        {
            aaa+="<tr>";
            aaa+="<td>"+dataArray[i].icCardNumber+"</td>";
            aaa+="<td>"+dataArray[i].chassisNumber+"</td>";
            aaa+="<td>"+dataArray[i].licensePlateColor+"</td>";
            aaa+="<td>"+dataArray[i].vehicleType+"</td>";
            aaa+="<td>"+dataArray[i].roadTransportLicense+"</td>";
            aaa+="<td>"+dataArray[i].maintainTimes+"</td>";
            aaa+="<td>"+dataArray[i].maintainRegistrationTime+"</td>";
            aaa+="<td>"+dataArray[i].maintainState+"</td>";
            aaa+="<td><a style=\"cursor:pointer\">查看详情<a/></td>";
            aaa+="<tr/>";
        }
        $('#secondMaintenanceRecordTr').html(aaa);
    }

    /**
     * 车辆检测记录
     */
    function  queryVehicleDetectionRecords(_vcrList){
        var dataArray=eval(_vcrList);
        var aaa="";
        for(var i in dataArray)
        {
            aaa+="<tr>";
            aaa+="<td>"+dataArray[i].icCardNumber+"</td>";
            aaa+="<td>"+dataArray[i].chassisNumber+"</td>";
            aaa+="<td>"+dataArray[i].licensePlateColor+"</td>";
            aaa+="<td>"+dataArray[i].vehicleType+"</td>";
            aaa+="<td>"+dataArray[i].roadTransportLicense+"</td>";
            aaa+="<td>"+dataArray[i].maintainTimes+"</td>";
            aaa+="<td>"+dataArray[i].maintainRegistrationTime+"</td>";
            aaa+="<td>"+dataArray[i].maintainTwoDimensionalEnterprises+"</td>";
            aaa+="<td>"+dataArray[i].maintainState+"</td>";
            aaa+="<td><a style=\"cursor:pointer\">查看详情<a/></td>";
            aaa+="<tr/>";
        }
        $('#vehicleDetectionRecordTr').html(aaa);
    }
    /**
     * 车辆合格证领取记录
     */
    function  queryCertificateReceivingRecords(_vcrList){
        var dataArray=eval(_vcrList);
        var aaa="";
        for(var i in dataArray)
        {
            aaa+="<tr>";
            aaa+="<td>"+dataArray[i].toraRepairParty+"</td>";
            aaa+="<td>"+dataArray[i].licensePlateNumber+"</td>";
            aaa+="<td>"+dataArray[i].carModel+"</td>";
            aaa+="<td>"+dataArray[i].maintenanceCategory+"</td>";
            aaa+="<td>"+dataArray[i].maintenanceContractNumber+"</td>";
            aaa+="<td>"+dataArray[i].outFactoryMileageValues+"</td>";
            aaa+="<td>"+dataArray[i].intoFactoryDate+"</td>";
            aaa+="<td>"+dataArray[i].outFactoryDate+"</td>";
            aaa+="<td><a style=\"cursor:pointer\">查看详情<a/></td>";
            aaa+="<tr/>";
        }
        $('#certificateReceivingRecordTr').html(aaa);
    }


    /**
     * 日常维护记录
     */

    function  queryRoutineMaintenanceRecords(_vcrList){
        var dataArray=eval(_vcrList);
        var aaa="";
        for(var i in dataArray)
        {
            aaa+="<tr>";
            aaa+="<td>"+dataArray[i].plate_number+"</td>";
            aaa+="<td>"+dataArray[i].vehicle_color+"</td>";
            aaa+="<td>"+ dataArray[i].maintain_time+"</td>";
            aaa+="<td>"+dataArray[i].maintain_project+"</td>";
            aaa+="<td>"+dataArray[i].maintain_content+"</td>";
            aaa+="<td>"+dataArray[i].remark+"</td>";
            aaa+="<td><a style=\"cursor:pointer\" plateNumber="+dataArray[i].plate_number+"    id="+dataArray[i].id+" onclick=\"editmaintain(this)\">编辑<a/>&nbsp;<a style=\"cursor:pointer\" plateNumber="+dataArray[i].plate_number+"    id="+dataArray[i].id+" onclick=\"delmaintain(this)\">删除<a/></td>";
            aaa+="<tr/>";
        }

        $('#routineMaintenanceRecordTr').html(aaa);
    }



    function  queryRoutineMaintenanceRecord(_vcrList){
        var dataArray=eval(_vcrList);
        for(var i in dataArray)
        {
           $('#wxsj').val(dataArray[i].maintain_time);
            $("#wxxm").val(dataArray[i].maintain_project);
            $("#wxnr").val(dataArray[i].maintain_content);
            $("#bz").val(dataArray[i].remark);
            $("#editMaintainId").val(dataArray[i].id);
        }
        $('#myinfoEditorModal').modal('show');
    }

        function cancelEditForm(){
            $('#wxsj').val("");
            $("#wxxm").val("");
            $("#wxnr").val("");
            $("#bz").val("");
           $("#editMaintainId").val("");
        }


