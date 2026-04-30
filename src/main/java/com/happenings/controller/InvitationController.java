//@RestController
//@RequestMapping("/api/invitations")
//@CrossOrigin
//public class InvitationController {
//
//  private final InvitationService invitationService;
//
//  public InvitationController(InvitationService invitationService) {
//    this.invitationService = invitationService;
//  }
//
//  @PostMapping
//  public String send(@RequestBody InviteRequest request) {
//    invitationService.sendInvite(request);
//    return "Invite sent";
//  }
//}