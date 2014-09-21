//
//  MasterViewController.m
//  AABE Prototype
//
//  Created by Rafagan Abreu on 17/07/14.
//  Copyright (c) 2014 Rafagan Abreu. All rights reserved.
//

#import "MasterViewController.h"

#import "DetailViewController.h"
#import "Jose.h"

@interface MasterViewController ()
@property (nonatomic, strong) NSArray *data;
@end

@implementation MasterViewController

- (void)awakeFromNib
{
    self.clearsSelectionOnViewWillAppear = NO;
    self.preferredContentSize = CGSizeMake(320.0, 600.0);
    [super awakeFromNib];
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    self.navigationItem.leftBarButtonItem = self.editButtonItem;

    self.detailViewController = (DetailViewController *)[[self.splitViewController.viewControllers lastObject] topViewController];
    
    [self configureRestKit];
    [self loadJose];

}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)configureRestKit
{
    // initialize AFNetworking HTTPClient
    NSURL *baseURL = [NSURL URLWithString:@"http://192.168.1.58:8080"];
    AFHTTPClient *client = [[AFHTTPClient alloc] initWithBaseURL:baseURL];
    
    // initialize RestKit
    RKObjectManager *objectManager = [[RKObjectManager alloc] initWithHTTPClient:client];
    
    // setup object mappings
    RKObjectMapping *joseMapping = [RKObjectMapping mappingForClass:[Jose class]];
    [joseMapping addAttributeMappingsFromDictionary:@{@"id" : @"joseId"}];
    [joseMapping addAttributeMappingsFromArray:@[@"name"]];
    
    // register mappings with the provider using a response descriptor
    RKResponseDescriptor *responseDescriptor =
    [RKResponseDescriptor responseDescriptorWithMapping:joseMapping
                                                 method:RKRequestMethodGET
                                            pathPattern:@"/AnatomicalAtlas/jose"
                                                keyPath:nil
                                            statusCodes:[NSIndexSet indexSetWithIndex:200]];
    
    [objectManager addResponseDescriptor:responseDescriptor];
}

- (void)loadJose
{
    [[RKObjectManager sharedManager] getObjectsAtPath:@"/AnatomicalAtlas/jose"
                                           parameters:nil
                                              success:^(RKObjectRequestOperation *operation, RKMappingResult *mappingResult) {
                                                  NSLog(@"Tesão pia!");
                                                  _data = mappingResult.array;
                                                  [self.tableView reloadData];
                                              }
                                              failure:^(RKObjectRequestOperation *operation, NSError *error) {
                                                  NSLog(@"Não deu certo");
                                              }];
}

#pragma mark - Table View

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return _data.count;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return _data.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"Cell" forIndexPath:indexPath];

    Jose *jose = _data[indexPath.row];
    cell.textLabel.text = jose.name;
    
    return cell;
}

- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the specified item to be editable.
    return YES;
}

- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath
{
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        
    } else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view.
    }
}

/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath
{
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
}

@end
