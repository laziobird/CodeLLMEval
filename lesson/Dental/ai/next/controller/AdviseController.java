package ai.next.controller;

import ai.next.dto.ExpertAdviseDto;
import ai.next.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/advice")
public class AdviseController extends BaseController {
    @Autowired
    AdviseService adviseService;
    @Autowired
    SaasApi saasApi;

    @PostMapping("/submitExpertAdvise")
    public Result<Integer> submitExpertAdvise(@RequestBody ExpertAdviseDto expertAdviseDto){
        Integer expertAdviseId = adviseService.addOrUpdateExpertAdvise(expertAdviseDto);
        return Result.succ(expertAdviseId);
    }

    @GetMapping("/expertAdvise")
    public Result<AceExternalExpertAdvise> queryExpertAdvise(@RequestParam("presOrderId") Integer presOrderId) throws IOException {
        AceExternalExpertAdvise expertAdvise = adviseService.expertAdvise(presOrderId);
        return Result.succ(expertAdvise);
    }

    @PostMapping("/confirmExpertAdvise")
    public Result<String> confirmExpertAdvise(@RequestBody ExpertAdviseDto expertAdviseDto) throws IOException {
        DoctorDto doctorDto = currentUserByOrderId(expertAdviseDto.getPresOrderId());
        adviseService.confirmExpertAdvise(expertAdviseDto.getPresOrderId(), doctorDto);
        return Result.succ("");
    }

    @PostMapping("/submitDoctorAdvice")
    public Result<String> submitDoctorAdvice(@RequestBody DoctorAdviceDto doctorAdviceDto) throws IOException {
        DoctorDto doctorDto = currentUserByOrderId(doctorAdviceDto.getPresOrderId());
        doctorAdviceDto.setDoctorId(doctorDto.getId());
        doctorAdviceDto.setDoctorName(doctorDto.getRealName());
        doctorAdviceDto.setDoctorDto(doctorDto);
        adviseService.submitDoctorAdvice(doctorAdviceDto);
        return Result.succ("");
    }

    @GetMapping("/doctorAdviceList")
    public Result<List<AceDoctorReplyAdvise>> doctorAdviceList(@RequestParam("presOrderId") Integer presOrderId){
        List<AceDoctorReplyAdvise> aceExternalDoctorAdvices = adviseService.doctorAdviceList(presOrderId);
        return Result.succ(aceExternalDoctorAdvices);
    }

    @PostMapping("/empty")
    public Result<String> empty(@RequestBody String request){
        log.info(request);
        return Result.succ(request);
    }

}
