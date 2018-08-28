package snapshotgenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		//String snapshotTemp = "<snapshotRecord sdpTimeZone=\"Turkey\"><account homeRegion=\"0\" groupId=\"0\" serviceOfferings=\"0\" promNotification=\"0\" isInTwoStepActivationMode=\"false\" isLocalCurrency=\"true\" isMarkedForDisconnect=\"false\" isNegBalanceBarred=\"false\" creditClearancePeriod=\"1023\" isCreditClearanceDone=\"false\" isSupervisionExpired=\"false\" isSupervisionWarn=\"false\" accountDisconnectPeriod=\"1023\" isServiceFeeExpired=\"false\" isServiceFeeExpiryWarn=\"false\" supervisionExpiryDate=\"2037-12-30T00:00:00Z\" serviceFeeExpiryDate=\"2037-12-30T00:00:00Z\" activatedDate=\"2017-12-29T00:00:00Z\" units=\"1000000.000000\" origServiceClass=\"8345\" serviceClass=\"8345\" masterMsisdn=\"$msisdn$\"></account><subscriber eocSelectionId=\"9\" language=\"1\" isFirstIvrCallDone=\"false\" refillFailCounter=\"0\" isSubFafCharged=\"false\" isTempBlocked=\"false\"><subscriberIdentity masterMsisdn=\"$msisdn$\" globalId=\"100AXXXX000000000000000000\" msisdn=\"$msisdn$\"/><wantedBlockStatus updateHLRReq=\"false\" isDisconnectSet=\"false\" isGPRSyncHLR=\"false\" isTermSMSSyncHLR=\"false\" isOrigSMSSyncHLR=\"false\" isTermVoiceSyncHLR=\"false\" isOrigVoiceSyncHLR=\"false\" GPRSThreshold=\"false\" termSMSThreshold=\"false\" origSMSThreshold=\"false\" GPRSStatus=\"true\" termSMSStatus=\"true\" origSMSStatus=\"true\" termVoiceStatus=\"true\" origVoiceStatus=\"true\"/><actualBlockStatus GPRSStatus=\"true\" termSMSStatus=\"true\" origSMSStatus=\"true\" termVoiceStatus=\"true\" origVoiceStatus=\"true\"/></subscriber></snapshotRecord>";
		String snapshotTemp = "<snapshotRecord sdpTimeZone=\"Turkey\">    <account homeRegion=\"0\" groupId=\"0\" serviceOfferings=\"0\" promNotification=\"0\" isInTwoStepActivationMode=\"false\" isLocalCurrency=\"true\" isMarkedForDisconnect=\"false\" isNegBalanceBarred=\"false\" creditClearancePeriod=\"1023\" isCreditClearanceDone=\"false\" isSupervisionExpired=\"false\" isSupervisionWarn=\"false\" accountDisconnectPeriod=\"1023\" isServiceFeeExpired=\"false\" isServiceFeeExpiryWarn=\"false\" supervisionExpiryDate=\"2037-12-30T00:00:00+03:00\" serviceFeeExpiryDate=\"2037-12-30T00:00:00+03:00\" activatedDate=\"1970-01-02T00:00:00+02:00\" units=\"1000000.000000\" origServiceClass=\"8415\" serviceClass=\"8415\" masterMsisdn=\"$msisdn$\" productIdCounter=\"702\">        <accumulatorList>            <accumulator clearingDate=\"2017-09-25T00:00:00+03:00\" counter=\"0\" id=\"700\"/>            <accumulator clearingDate=\"2017-09-25T00:00:00+03:00\" counter=\"0\" id=\"701\"/>            <accumulator clearingDate=\"2017-09-25T00:00:00+03:00\" counter=\"0\" id=\"702\"/>            <accumulator clearingDate=\"2017-09-25T00:00:00+03:00\" counter=\"0\" id=\"703\"/>            <accumulator clearingDate=\"2017-09-25T00:00:00+03:00\" counter=\"0\" id=\"704\"/>            <accumulator counter=\"0\" id=\"729711\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"933931\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"933951\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"999711\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"999712\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"999811\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"999812\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"999911\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"999912\"/>            <accumulator clearingDate=\"2014-04-13T00:00:00+03:00\" counter=\"0\" id=\"1100622\"/>            <accumulator clearingDate=\"2014-04-23T00:00:00+03:00\" counter=\"0\" id=\"1100625\"/>            <accumulator clearingDate=\"2014-04-13T00:00:00+03:00\" counter=\"0\" id=\"1100626\"/>            <accumulator clearingDate=\"2014-04-23T00:00:00+03:00\" counter=\"0\" id=\"1100627\"/>            <accumulator clearingDate=\"2014-04-23T00:00:00+03:00\" counter=\"0\" id=\"1100630\"/>            <accumulator clearingDate=\"2014-04-13T00:00:00+03:00\" counter=\"0\" id=\"1100635\"/>            <accumulator clearingDate=\"2015-03-19T00:00:00+02:00\" counter=\"0\" id=\"1100636\"/>            <accumulator clearingDate=\"2015-03-19T00:00:00+02:00\" counter=\"0\" id=\"1100637\"/>            <accumulator clearingDate=\"2014-04-13T00:00:00+03:00\" counter=\"0\" id=\"1100638\"/>            <accumulator clearingDate=\"2015-03-19T00:00:00+02:00\" counter=\"0\" id=\"1100639\"/>            <accumulator clearingDate=\"2014-04-13T00:00:00+03:00\" counter=\"0\" id=\"1100641\"/>            <accumulator clearingDate=\"2014-07-27T00:00:00+03:00\" counter=\"0\" id=\"1100642\"/>            <accumulator clearingDate=\"2014-07-27T00:00:00+03:00\" counter=\"0\" id=\"1100643\"/>            <accumulator clearingDate=\"2014-04-13T00:00:00+03:00\" counter=\"0\" id=\"1100644\"/>            <accumulator clearingDate=\"2015-03-19T00:00:00+02:00\" counter=\"0\" id=\"1100646\"/>            <accumulator clearingDate=\"2015-03-19T00:00:00+02:00\" counter=\"0\" id=\"1100647\"/>            <accumulator clearingDate=\"2015-04-21T00:00:00+03:00\" counter=\"0\" id=\"1100652\"/>            <accumulator clearingDate=\"2015-04-20T00:00:00+03:00\" counter=\"0\" id=\"1100654\"/>            <accumulator clearingDate=\"2015-04-21T00:00:00+03:00\" counter=\"0\" id=\"1100655\"/>            <accumulator clearingDate=\"2016-06-30T00:00:00+03:00\" counter=\"0\" id=\"1100659\"/>            <accumulator clearingDate=\"2015-04-20T00:00:00+03:00\" counter=\"0\" id=\"1100660\"/>            <accumulator clearingDate=\"2016-06-30T00:00:00+03:00\" counter=\"0\" id=\"1100661\"/>            <accumulator clearingDate=\"2015-07-13T00:00:00+03:00\" counter=\"0\" id=\"1100665\"/>            <accumulator clearingDate=\"2015-07-13T00:00:00+03:00\" counter=\"0\" id=\"1100666\"/>            <accumulator clearingDate=\"2015-04-21T00:00:00+03:00\" counter=\"0\" id=\"1100667\"/>            <accumulator clearingDate=\"2015-04-21T00:00:00+03:00\" counter=\"0\" id=\"1100668\"/>            <accumulator clearingDate=\"2016-06-30T00:00:00+03:00\" counter=\"0\" id=\"1100669\"/>            <accumulator clearingDate=\"2016-06-30T00:00:00+03:00\" counter=\"0\" id=\"1100670\"/>            <accumulator clearingDate=\"2015-04-20T00:00:00+03:00\" counter=\"0\" id=\"1100685\"/>            <accumulator clearingDate=\"2015-04-20T00:00:00+03:00\" counter=\"0\" id=\"1100686\"/>            <accumulator clearingDate=\"2015-04-20T00:00:00+03:00\" counter=\"0\" id=\"1100687\"/>            <accumulator clearingDate=\"2015-04-20T00:00:00+03:00\" counter=\"0\" id=\"1100688\"/>            <accumulator clearingDate=\"2015-04-20T00:00:00+03:00\" counter=\"0\" id=\"1100689\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101143\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101144\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101150\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101151\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101152\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101153\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101154\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101155\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101156\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101157\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101158\"/>            <accumulator clearingDate=\"2013-09-25T00:00:00+03:00\" counter=\"0\" id=\"1101159\"/>            <accumulator clearingDate=\"2015-04-21T00:00:00+03:00\" counter=\"0\" id=\"1101289\"/>            <accumulator clearingDate=\"2015-04-21T00:00:00+03:00\" counter=\"0\" id=\"1101290\"/>            <accumulator clearingDate=\"2015-04-21T00:00:00+03:00\" counter=\"0\" id=\"1101291\"/>            <accumulator clearingDate=\"2015-04-21T00:00:00+03:00\" counter=\"0\" id=\"1101292\"/>            <accumulator clearingDate=\"2014-08-23T00:00:00+03:00\" counter=\"0\" id=\"1101904\"/>            <accumulator clearingDate=\"2014-08-23T00:00:00+03:00\" counter=\"0\" id=\"1101917\"/>            <accumulator clearingDate=\"2014-06-25T00:00:00+03:00\" counter=\"0\" id=\"1102032\"/>            <accumulator clearingDate=\"2014-06-25T00:00:00+03:00\" counter=\"0\" id=\"1102033\"/>            <accumulator clearingDate=\"2014-06-25T00:00:00+03:00\" counter=\"0\" id=\"1102034\"/>            <accumulator clearingDate=\"2014-10-25T00:00:00+03:00\" counter=\"0\" id=\"1102124\"/>            <accumulator clearingDate=\"2014-10-25T00:00:00+03:00\" counter=\"0\" id=\"1102128\"/>            <accumulator clearingDate=\"2014-07-27T00:00:00+03:00\" counter=\"0\" id=\"1102129\"/>            <accumulator clearingDate=\"2015-03-19T00:00:00+02:00\" counter=\"0\" id=\"1102130\"/>            <accumulator clearingDate=\"2014-07-27T00:00:00+03:00\" counter=\"0\" id=\"1102131\"/>            <accumulator clearingDate=\"2015-03-19T00:00:00+02:00\" counter=\"0\" id=\"1102132\"/>            <accumulator clearingDate=\"2015-02-25T00:00:00+02:00\" counter=\"0\" id=\"1102554\"/>            <accumulator clearingDate=\"2015-02-25T00:00:00+02:00\" counter=\"0\" id=\"1102555\"/>            <accumulator clearingDate=\"2017-08-09T00:00:00+03:00\" counter=\"0\" id=\"1102655\"/>            <accumulator clearingDate=\"2017-08-09T00:00:00+03:00\" counter=\"0\" id=\"1102671\"/>            <accumulator clearingDate=\"2017-08-09T00:00:00+03:00\" counter=\"0\" id=\"1102672\"/>            <accumulator clearingDate=\"2017-08-09T00:00:00+03:00\" counter=\"0\" id=\"1102673\"/>            <accumulator clearingDate=\"2017-08-09T00:00:00+03:00\" counter=\"0\" id=\"1102693\"/>            <accumulator clearingDate=\"2017-08-09T00:00:00+03:00\" counter=\"0\" id=\"1102694\"/>            <accumulator clearingDate=\"2017-08-09T00:00:00+03:00\" counter=\"0\" id=\"1102696\"/>            <accumulator clearingDate=\"2017-08-09T00:00:00+03:00\" counter=\"0\" id=\"1102697\"/>            <accumulator clearingDate=\"2015-09-14T00:00:00+03:00\" counter=\"0\" id=\"1102865\"/>            <accumulator clearingDate=\"2015-09-14T00:00:00+03:00\" counter=\"0\" id=\"1102869\"/>            <accumulator clearingDate=\"2016-07-18T00:00:00+03:00\" counter=\"7\" id=\"1103953\"/>            <accumulator clearingDate=\"2016-07-16T00:00:00+03:00\" counter=\"40\" id=\"1103955\"/>            <accumulator clearingDate=\"2017-03-15T00:00:00+03:00\" counter=\"0\" id=\"1104524\"/>            <accumulator clearingDate=\"2017-03-15T00:00:00+03:00\" counter=\"0\" id=\"1104525\"/>            <accumulator clearingDate=\"2017-03-15T00:00:00+03:00\" counter=\"0\" id=\"1104526\"/>            <accumulator clearingDate=\"2017-03-15T00:00:00+03:00\" counter=\"0\" id=\"1104528\"/>            <accumulator clearingDate=\"2017-08-09T00:00:00+03:00\" counter=\"0\" id=\"1104626\"/>            <accumulator clearingDate=\"2017-08-09T00:00:00+03:00\" counter=\"0\" id=\"1104627\"/>        </accumulatorList>        <dedicatedAccountList>            <dedicatedAccount expiryDate=\"2017-10-21T00:00:00+03:00\" startDate=\"2017-08-12T00:00:00+03:00\" balance=\"780\" id=\"1100651\"/>            <dedicatedAccount productId=\"688\" balance=\"0\" id=\"1103174\"/>            <dedicatedAccount productId=\"700\" balance=\"2147483\" id=\"1103174\"/>            <dedicatedAccount productId=\"685\" balance=\"23868\" id=\"1103177\"/>            <dedicatedAccount productId=\"697\" balance=\"30000\" id=\"1103177\"/>            <dedicatedAccount productId=\"686\" balance=\"536870\" id=\"1104267\"/>            <dedicatedAccount productId=\"698\" balance=\"536870\" id=\"1104267\"/>        </dedicatedAccountList>        <pamAccountList>            <pamAccount priority=\"0\" lastEvaluationDate=\"2017-09-25T00:00:00+03:00\" currentPeriod=\"October-2017\" scheduleId=\"7\" classId=\"1\" pamServiceId=\"1\" serviceId=\"0\"/>            <pamAccount priority=\"1\" lastEvaluationDate=\"2017-09-25T00:00:00+03:00\" currentPeriod=\"Mon\" scheduleId=\"100\" classId=\"2\" pamServiceId=\"2\" serviceId=\"0\"/>        </pamAccountList>        <community id1=\"247\"/>        <offerList>            <offer isDisabled=\"false\" id=\"10006704\" startDateTime=\"2016-06-29T18:18:03+03:00\" expiryDateTime=\"2017-09-29T18:18:03+03:00\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"10011544\"/>            <offer isDisabled=\"false\" id=\"10012240\" pamServiceId=\"1\" startDateTime=\"2014-04-25T00:00:00+03:00\"/>            <offer isDisabled=\"false\" id=\"10013332\" pamServiceId=\"1\" startDateTime=\"2016-06-29T12:15:23+03:00\"/>            <offer isDisabled=\"false\" id=\"10013335\" pamServiceId=\"1\" startDateTime=\"2016-06-29T12:15:23+03:00\"/>            <offer isDisabled=\"false\" id=\"10013437\" pamServiceId=\"2\" startDateTime=\"2015-12-22T00:00:00+02:00\"/>            <offer isDisabled=\"false\" id=\"10013743\" startDateTime=\"2016-06-21T22:00:00+03:00\"/>            <offer isDisabled=\"false\" id=\"10014176\" startDateTime=\"2017-08-30T09:00:00+03:00\" expiryDateTime=\"2017-08-31T09:00:00+03:00\"/>            <offer isDisabled=\"false\" id=\"10014284\" pamServiceId=\"1\" startDateTime=\"2016-12-25T00:00:00+03:00\"/>            <offer isDisabled=\"false\" id=\"10014308\" startDateTime=\"2016-12-25T05:54:49+03:00\"/>            <offer isDisabled=\"false\" id=\"10014309\" startDateTime=\"2016-12-25T05:54:49+03:00\"/>            <offer isDisabled=\"false\" id=\"20057861\" pamServiceId=\"1\" startDateTime=\"2016-06-29T12:14:36+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer productId=\"691\" isDisabled=\"false\" id=\"20067041\" startDateTime=\"2017-08-29T18:18:03+03:00\" expiryDateTime=\"2017-09-29T18:18:03+03:00\"/>            <offer isDisabled=\"false\" id=\"20071341\" pamServiceId=\"1\" startDateTime=\"2016-06-29T12:14:36+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111034\"/>            <offer isDisabled=\"false\" expiryDate=\"2017-09-10T00:00:00+03:00\" startDate=\"2017-08-12T00:00:00+03:00\" id=\"20111035\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111038\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111043\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111047\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111053\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111058\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111063\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111085\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111086\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111087\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111088\"/>            <offer isDisabled=\"false\" expiryDate=\"2037-05-25T00:00:00+03:00\" startDate=\"2017-05-25T00:00:00+03:00\" id=\"20111089\"/>            <offer productId=\"684\" isDisabled=\"false\" id=\"20113674\" pamServiceId=\"1\" startDateTime=\"2017-08-25T00:00:00+03:00\" expiryDateTime=\"2017-09-25T00:00:00+03:00\"/>            <offer productId=\"696\" isDisabled=\"false\" id=\"20113674\" pamServiceId=\"1\" startDateTime=\"2017-09-25T00:00:00+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer productId=\"681\" isDisabled=\"false\" id=\"20113733\" pamServiceId=\"1\" startDateTime=\"2017-08-25T00:00:00+03:00\" expiryDateTime=\"2017-09-25T00:00:00+03:00\"/>            <offer productId=\"693\" isDisabled=\"false\" id=\"20113733\" pamServiceId=\"1\" startDateTime=\"2017-09-25T00:00:00+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer productId=\"682\" isDisabled=\"false\" id=\"20113734\" pamServiceId=\"1\" startDateTime=\"2017-08-25T00:00:00+03:00\" expiryDateTime=\"2017-09-25T00:00:00+03:00\"/>            <offer productId=\"694\" isDisabled=\"false\" id=\"20113734\" pamServiceId=\"1\" startDateTime=\"2017-09-25T00:00:00+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer productId=\"689\" isDisabled=\"false\" id=\"20114824\" pamServiceId=\"1\" startDateTime=\"2017-08-25T00:00:00+03:00\" expiryDateTime=\"2017-09-25T00:00:00+03:00\"/>            <offer productId=\"701\" isDisabled=\"false\" id=\"20114824\" pamServiceId=\"1\" startDateTime=\"2017-09-25T00:00:00+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer productId=\"688\" isDisabled=\"false\" id=\"20114825\" pamServiceId=\"1\" startDateTime=\"2017-08-25T00:00:00+03:00\" expiryDateTime=\"2017-09-25T00:00:00+03:00\"/>            <offer productId=\"700\" isDisabled=\"false\" id=\"20114825\" pamServiceId=\"1\" startDateTime=\"2017-09-25T00:00:00+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer productId=\"685\" isDisabled=\"false\" id=\"20114830\" pamServiceId=\"1\" startDateTime=\"2017-08-25T00:00:00+03:00\" expiryDateTime=\"2017-09-25T00:00:00+03:00\"/>            <offer productId=\"697\" isDisabled=\"false\" id=\"20114830\" pamServiceId=\"1\" startDateTime=\"2017-09-25T00:00:00+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer productId=\"690\" isDisabled=\"false\" id=\"20115048\" pamServiceId=\"1\" startDateTime=\"2017-08-25T00:00:00+03:00\" expiryDateTime=\"2017-09-25T00:00:00+03:00\"/>            <offer productId=\"702\" isDisabled=\"false\" id=\"20115048\" pamServiceId=\"1\" startDateTime=\"2017-09-25T00:00:00+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer productId=\"654\" isDisabled=\"false\" id=\"20115535\" startDateTime=\"2017-05-25T00:00:01+03:00\" expiryDateTime=\"2037-05-25T00:00:01+03:00\"/>            <offer productId=\"655\" isDisabled=\"false\" id=\"20115536\" startDateTime=\"2017-05-25T00:00:01+03:00\" expiryDateTime=\"2037-05-25T00:00:01+03:00\"/>            <offer productId=\"656\" isDisabled=\"false\" id=\"20115553\" startDateTime=\"2017-05-25T00:00:01+03:00\" expiryDateTime=\"2037-05-25T00:00:01+03:00\"/>            <offer isDisabled=\"false\" id=\"20115835\" startDateTime=\"2016-06-21T22:00:00+03:00\"/>            <offer productId=\"683\" isDisabled=\"false\" id=\"20115958\" pamServiceId=\"1\" startDateTime=\"2017-08-25T00:00:00+03:00\" expiryDateTime=\"2017-09-25T00:00:00+03:00\"/>            <offer productId=\"695\" isDisabled=\"false\" id=\"20115958\" pamServiceId=\"1\" startDateTime=\"2017-09-25T00:00:00+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer isDisabled=\"false\" id=\"20116476\" startDateTime=\"2017-08-30T09:00:00+03:00\" expiryDateTime=\"2017-08-31T09:00:00+03:00\"/>            <offer isDisabled=\"false\" id=\"20116479\" startDateTime=\"2017-08-30T09:00:00+03:00\" expiryDateTime=\"2017-08-31T09:00:00+03:00\"/>            <offer isDisabled=\"false\" id=\"20116480\" startDateTime=\"2017-08-30T09:00:00+03:00\" expiryDateTime=\"2017-08-31T09:00:00+03:00\"/>            <offer productId=\"687\" isDisabled=\"false\" id=\"20116662\" pamServiceId=\"1\" startDateTime=\"2017-08-25T00:00:00+03:00\" expiryDateTime=\"2017-09-25T00:00:00+03:00\"/>            <offer productId=\"699\" isDisabled=\"false\" id=\"20116662\" pamServiceId=\"1\" startDateTime=\"2017-09-25T00:00:00+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer productId=\"686\" isDisabled=\"false\" id=\"20116663\" pamServiceId=\"1\" startDateTime=\"2017-08-25T00:00:00+03:00\" expiryDateTime=\"2017-09-25T00:00:00+03:00\"/>            <offer productId=\"698\" isDisabled=\"false\" id=\"20116663\" pamServiceId=\"1\" startDateTime=\"2017-09-25T00:00:00+03:00\" expiryDateTime=\"2017-10-25T00:00:00+03:00\"/>            <offer isDisabled=\"false\" id=\"20117997\" startDateTime=\"2017-08-30T09:00:00+03:00\" expiryDateTime=\"2017-08-31T09:00:00+03:00\"/>            <offer isDisabled=\"false\" id=\"80008415\" pamServiceId=\"1\" startDateTime=\"2016-06-29T12:15:23+03:00\"/>        </offerList>    </account>    <subscriber eocSelectionId=\"9\" language=\"1\" isFirstIvrCallDone=\"false\" refillFailCounter=\"0\" isSubFafCharged=\"false\" isTempBlocked=\"false\">        <usageCounterList>            <usageCounter productId=\"691\" value=\"90\" id=\"670411\"/>            <usageCounter value=\"142.949720\" id=\"1102871\"/>            <usageCounter value=\"4767744\" id=\"1104160\"/>            <usageCounter value=\"246\" id=\"1104163\"/>        </usageCounterList>        <announceSetting specialAnnouncePlayedDate=\"2017-09-24T00:00:00+03:00\"/>        <subscriberIdentity masterMsisdn=\"$msisdn$\" globalId=\"100A5322553122000000000000000000\" msisdn=\"$msisdn$\"/>        <wantedBlockStatus updateHLRReq=\"false\" isDisconnectSet=\"false\" isGPRSyncHLR=\"false\" isTermSMSSyncHLR=\"false\" isOrigSMSSyncHLR=\"false\" isTermVoiceSyncHLR=\"false\" isOrigVoiceSyncHLR=\"false\" GPRSThreshold=\"false\" termSMSThreshold=\"false\" origSMSThreshold=\"false\" GPRSStatus=\"true\" termSMSStatus=\"true\" origSMSStatus=\"true\" termVoiceStatus=\"true\" origVoiceStatus=\"true\"/>        <actualBlockStatus GPRSStatus=\"true\" termSMSStatus=\"true\" origSMSStatus=\"true\" termVoiceStatus=\"true\" origVoiceStatus=\"true\"/>    </subscriber></snapshotRecord>";
		
		BigDecimal msisdn = new BigDecimal("7360000000");
		int numberOfFiles = 3000;
		int numberOfSubs = 1;
		long counter = 0;
		try {
			for (int k =0 ; k < numberOfFiles; k++) {
				FileOutputStream testFileOutput = new FileOutputStream("200KMultipleFiles"+k+".xml");
				testFileOutput.write("<snapshotData>".getBytes());
				testFileOutput.write("\n".getBytes());
				for(int i = 0; i< numberOfSubs; i++){
					counter++;
					BigDecimal msisdnToAdd = msisdn.add(new BigDecimal(counter));
					System.out.println(msisdnToAdd);
					String snap = snapshotTemp.replace("$msisdn$", msisdnToAdd.toString());
					testFileOutput.write(snap.getBytes());
					testFileOutput.write("\n".getBytes());
					if(i%1000==0){
						System.out.println("File Generation goes on:" + i);
					}
				}
				testFileOutput.write("</snapshotData>".getBytes());
				System.out.println("closing");
				testFileOutput.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}